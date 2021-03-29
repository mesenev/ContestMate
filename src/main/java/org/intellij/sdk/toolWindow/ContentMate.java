// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.*;


public class ContentMate {

    private void make_json() throws IOException {
        Process executable = Runtime.getRuntime().exec("python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\test.py");
    }

    private JPanel myToolWindowContent;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTable table1;

    public String[] columnNames = {"username", "task", "result"};


    public ContentMate(ToolWindow toolWindow) throws IOException {
        make_json();
        List<String> list = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        String jsonString = new String(Files.readAllBytes(Paths.get("res.json")));
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("submit");
        for (int i = 0; i < arr.length(); i++) {
            list.add(arr.getJSONObject(i).getString("username"));
            list.add(arr.getJSONObject(i).getString("problem_name"));
            list.add(arr.getJSONObject(i).getString("current_status"));
            model.addRow(list.toArray());
            list.clear();
        }
        table1.setModel(model);
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
