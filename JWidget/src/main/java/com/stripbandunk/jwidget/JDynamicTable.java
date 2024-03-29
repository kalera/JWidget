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
package com.stripbandunk.jwidget;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import com.stripbandunk.jwidget.annotation.TableColumn;
import com.stripbandunk.jwidget.editor.NoTableCellEditor;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import com.stripbandunk.jwidget.renderer.NoTableCellRenderer;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class JDynamicTable extends JTable {

    private static final long serialVersionUID = 1L;

    public JDynamicTable() {
        this(new DynamicTableModel<DummyEntity>(DummyEntity.class));
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public JDynamicTable(DynamicTableModel<?> tableModel) {
        setDynamicModel(tableModel);
        initComponent();
    }

    private void initComponent() {
        setAutoResizeMode(JDynamicTable.AUTO_RESIZE_OFF);
        setAutoCreateRowSorter(true);
    }

    public void setDynamicModel(DynamicTableModel<?> model) {
        setModel(model);
    }

    public DynamicTableModel<?> getDynamicModel() {
        if (super.getModel() instanceof DynamicTableModel) {
            DynamicTableModel<?> dynamicTableModel = (DynamicTableModel) super.getModel();
            return dynamicTableModel;
        } else {
            return null;
        }
    }

    @Override
    @Deprecated
    public TableModel getModel() {
        return super.getModel();
    }

    @Override
    @Deprecated
    public void setModel(TableModel dataModel) {
        if (dataModel instanceof DynamicTableModel) {
            super.setModel(dataModel);
            DynamicTableModel<?> dynamicTableModel = (DynamicTableModel) dataModel;
            fireChangeTableCellRenderer(dynamicTableModel);
            fireChangeTableCellEditor(dynamicTableModel);
            fireChangeTableHeaderSize(dynamicTableModel);
        } else {
            super.setModel(dataModel);
        }
    }

    protected void fireChangeTableHeaderSize(DynamicTableModel<?> dynamicTableModel) {
        for (int i = 0; i < dynamicTableModel.getColumnCount(); i++) {
            int size = dynamicTableModel.getSize(i) * getFontMetrics(getFont()).charWidth('A');
            getColumnModel().getColumn(i).setMinWidth(size);
        }
    }

    protected void fireChangeTableCellRenderer(DynamicTableModel<?> dynamicTableModel) {
        for (int i = 0; i < dynamicTableModel.getColumnCount(); i++) {
            try {
                if (!dynamicTableModel.getTableCellRenderer(i).equals(NoTableCellRenderer.class)) {
                    TableCellRenderer renderer = (TableCellRenderer) dynamicTableModel.getTableCellRenderer(i).newInstance();
                    getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(JDynamicTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(JDynamicTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    protected void fireChangeTableCellEditor(DynamicTableModel<?> dynamicTableModel) {
        for (int i = 0; i < dynamicTableModel.getColumnCount(); i++) {
            try {
                if (!dynamicTableModel.getTableCellEditor(i).equals(NoTableCellEditor.class)) {
                    TableCellEditor editor = (TableCellEditor) dynamicTableModel.getTableCellEditor(i).newInstance();
                    getColumnModel().getColumn(i).setCellEditor(editor);
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(JDynamicTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(JDynamicTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Dummy Entity">
    private class DummyEntity implements Serializable {

        private static final long serialVersionUID = 2L;

        @TableColumn(name = "D", number = 1)
        private String a;

        @TableColumn(name = "U", number = 2)
        private String b;

        @TableColumn(name = "M", number = 3)
        private String c;

        @TableColumn(name = "M", number = 4)
        private String d;

        @TableColumn(name = "Y", number = 5)
        private String e;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        public String getE() {
            return e;
        }

        public void setE(String e) {
            this.e = e;
        }
    }
    //</editor-fold>
}
