package org.intellij.sdk.toolWindow;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubmitTableModel implements TableModel {

    private final Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    public List<Submit> data;

    public SubmitTableModel(List<Submit> data) {
        this.data = data;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Problem";
            case 1:
                return "User";
            case 2:
                return "Status";
        }
        return "";
    }

    public int getRowCount() {
        return data.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Submit element = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return element.problem_name;
            case 1:
                return element.username;
            case 2:
                return element.current_status;
        }
        return element;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

    public void reset() {
        data.clear();
    }
}
