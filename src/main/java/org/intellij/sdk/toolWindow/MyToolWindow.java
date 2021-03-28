// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MyToolWindow {

    private JPanel myToolWindowContent;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTable table1;


    public MyToolWindow(ToolWindow toolWindow) {
        List<String> list = new ArrayList<String>();
        list.add("Bodgan Kovalchuk");
        list.add("Byki i korovy");
        list.add("AM");
        Object[] columnsHeader = new String[] {"Наименование", "Ед.измерения", "Количество"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnsHeader);
        model.addRow(list.toArray());
        table1.setModel(model);
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
