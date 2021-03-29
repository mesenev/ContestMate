// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;


public class MyToolWindow {

    private JPanel myToolWindowContent;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTable table1;


    public MyToolWindow(ToolWindow toolWindow) throws IOException {
        Process executable = Runtime.getRuntime().exec("python C:\\Users\\mrrla\\IdeaProjects\\ContestMate\\test.py");
        String[] columnNames = {"username", "task", "result"};
        Object[][] data = {{"a", "s", "d"}, {"s", "m", "l"}};

        String jsonString = new String(Files.readAllBytes(Paths.get("res.json")));
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("submit");
        for (int i = 0; i < arr.length(); i++) {
            String username = arr.getJSONObject(i).getString("username");
            System.out.println(username);
            String problem = arr.getJSONObject(i).getString("problem_name");
            System.out.println(problem);
            String result = arr.getJSONObject(i).getString("current_status");
            System.out.println(result);
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
