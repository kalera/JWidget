/*
 *  Copyright 2011 Eko Kurniawan Khannedy.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.stripbandunk.jwidget.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import com.stripbandunk.jwidget.comparator.TableColumnComparator;
import com.stripbandunk.jwidget.util.ArrayUtilities;

/**
 *
 * @param <T> 
 * @author Eko Kurniawan Khannedy
 */
public class DynamicTableModel<T> extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<T> data;

    private List<Field> fields;

    private String group;

    private Class<T> clazz;

    public DynamicTableModel(Class<T> clazz) {
        this(new ArrayList<T>(0), clazz);
    }

    public DynamicTableModel(List<T> data, Class<T> clazz) {
        this.data = data;
        this.clazz = clazz;
        fields = new ArrayList<Field>(0);

        initTableModel();
    }

    private void initTableModel() {
        fields.clear();

        Field[] fs = this.clazz.getDeclaredFields();
        for (Field field : fs) {
            TableColumn column = field.getAnnotation(TableColumn.class);
            if (column != null) {
                if (group == null) {
                    field.setAccessible(true);
                    fields.add(field);
                } else {
                    if (ArrayUtilities.contains(column.groups(), group)) {
                        field.setAccessible(true);
                        fields.add(field);
                    }
                }
            }
        }

        Collections.sort(fields, new TableColumnComparator());
    }

    public T set(int index, T element) {
        try {
            return data.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public void clear() {
        try {
            data.clear();
        } finally {
            fireTableDataChanged();
        }
    }

    public T remove(int index) {
        try {
            return data.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public T get(int index) {
        return data.get(index);
    }

    public boolean add(T e) {
        try {
            return data.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
        initTableModel();
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return fields.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return fields.get(columnIndex).get(data.get(rowIndex));
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DynamicTableModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return fields.get(columnIndex).getType();
    }

    @Override
    public String getColumnName(int column) {
        return fields.get(column).getAnnotation(TableColumn.class).name();
    }

    public List<T> getData() {
        return Collections.unmodifiableList(data);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return fields.get(columnIndex).getAnnotation(TableColumn.class).editable();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            fields.get(columnIndex).set(data.get(rowIndex), aValue);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DynamicTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Class<? extends TableCellEditor> getTableCellEditor(int column) {
        return fields.get(column).getAnnotation(TableColumn.class).editor();
    }

    public Class<? extends TableCellRenderer> getTableCellRenderer(int column) {
        return fields.get(column).getAnnotation(TableColumn.class).renderer();
    }

    public int getSize(int column) {
        return fields.get(column).getAnnotation(TableColumn.class).size();
    }
}
