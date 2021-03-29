// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.intellij.sdk.toolWindow

import com.intellij.openapi.wm.ToolWindow
import java.util.ArrayList
import javax.swing.*
import javax.swing.table.DefaultTableModel

class MyToolWindow(toolWindow: ToolWindow?) {
    val content: JPanel? = null
    private val comboBox1: JComboBox<*>? = null
    private val textField1: JTextField? = null
    private val textField2: JTextField? = null
    private val button1: JButton? = null
    private val table1: JTable? = null

    init {
        val list: MutableList<String> = ArrayList()
        list.add("Bodgan Kovalchuk")
        list.add("Byki i korovy")
        list.add("AM")
        val columnsHeader: Array<Any> = arrayOf<Any>("Наименование", "Ед.измерения", "Количество")
        val model = DefaultTableModel()
        model.setColumnIdentifiers(columnsHeader)
        model.addRow(list.toTypedArray())
        table1!!.model = model
    }
}