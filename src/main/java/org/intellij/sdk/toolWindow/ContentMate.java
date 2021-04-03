// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;


import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


public class ContentMate {


    //
    //System.out.println(settings.script1_makeJson_settings);

    private JPanel myToolWindowContent;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loadButton;
    private static Integer submitID;
    public AppSettingsState settings = AppSettingsState.getInstance();
    public JTable table1;
    public List<Submit> data_submits = new ArrayList<>();
    public StringBuilder jsonString = new StringBuilder();
    String line;
    SubmitTableModel model = new SubmitTableModel(data_submits);

    public static Path downloadFile(String urlString, Path downloadDirectory, String name, String username) throws IOException {
        URL url = new URL(urlString);
        String filename = name;
        String suffix = username;
        InputStream inputStream = url.openStream();
        Path tempFile = Files.createTempFile(filename, suffix);
        Path target = Paths.get(downloadDirectory + "/" + filename + suffix);
        if (!target.toFile().exists()) {
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            Files.move(tempFile, target);
        }
        return target;
    }


    public ContentMate(ToolWindow toolWindow) throws IOException {
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = table1.getSelectionModel();

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                submitID = model.data.get(table1.getSelectedRow()).id_submit;
                String pathtofile = "C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\src\\main\\files\\"
                        + model.data.get(table1.getSelectedRow()).id_submit
                        + model.data.get(table1.getSelectedRow()).id_problem;
                @Nullable VirtualFile file = LocalFileSystem.getInstance().findFileByPath(pathtofile);
                FileEditorManager.getInstance(ProjectManager.getInstance().getOpenProjects()[0]).openFile(file, true);
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.reset();
                    make_json();
                    table1.setModel(model);
                    table1.transferFocus();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public static Integer SubmitId() {
        return submitID;
    }

    public void make_json() throws IOException {
        data_submits.clear();
        jsonString.setLength(0);
        Process executable = Runtime.getRuntime().exec(settings.script1_makeJson_settings + settings.sid + settings.tournament);
        BufferedReader is = new BufferedReader(new InputStreamReader(executable.getInputStream()));

        while ((line = is.readLine()) != null) {
            jsonString.append(line);
        }
        JSONObject obj = new JSONObject(jsonString.toString());
        JSONArray arr = obj.getJSONArray("submit");

        for (int i = 0; i < arr.length(); i++) {
            Submit a = new Submit(
                    arr.getJSONObject(i).getInt("id_problem"),
                    arr.getJSONObject(i).getString("problem_name"),
                    arr.getJSONObject(i).getInt("id_submit"),
                    arr.getJSONObject(i).getString("username"),
                    arr.getJSONObject(i).getString("content_link"),
                    arr.getJSONObject(i).getString("current_status")
            );
            data_submits.add(a);
            downloadFile(a.content_link, Paths.get("C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\src\\main\\files"), String.valueOf(a.id_submit), String.valueOf(a.id_problem));
        }

        executable.destroy();
        is.close();
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
