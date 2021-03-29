// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

import org.json.*;

import java.util.List;

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
        Object[][] data = {
                {"Petr Losev", "Bridges",
                        "AW"},
                {"Darya Fedotova", "Stones",
                        "OK"},
                {"Pavel Rudnik", "Django",
                        "CE"},
                {"Bogdan Kovalchuk", "Pygame",
                        "RE"},
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
