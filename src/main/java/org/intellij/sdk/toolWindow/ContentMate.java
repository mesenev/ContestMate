// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.*;


public class ContentMate implements DataProvider {


    private JPanel myToolWindowContent;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loadButton;
    public JTable table1;

    private static Integer submitID;
    public List<Submit> data_submits = new ArrayList<>();
    public StringBuilder jsonString = new StringBuilder();
    String line;
    SubmitTableModel model = new SubmitTableModel(data_submits);


    public void make_json() throws IOException {
        data_submits.clear();
        jsonString.setLength(0);
        Process executable = Runtime.getRuntime().exec("python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\test.py");
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
        }

        executable.destroy();
        is.close();
    }


    public ContentMate(ToolWindow toolWindow) throws IOException {

        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = table1.getSelectionModel();

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(table1.getSelectedRow());
                submitID = model.data.get(table1.getSelectedRow()).id_submit;
                @Nullable VirtualFile file = LocalFileSystem.getInstance().findFileByPath("C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\settings.gradle");
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
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

    }

    public static Integer SubmitId() {
        return submitID;
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }

    @Override
    public @Nullable Object getData(@NotNull String dataId) {
        return table1.getSelectedRow();
    }
}
