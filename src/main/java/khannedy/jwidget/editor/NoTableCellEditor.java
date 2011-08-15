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
package khannedy.jwidget.editor;

import java.awt.Component;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@SuppressWarnings("FinalClass")
public final class NoTableCellEditor implements TableCellEditor {

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getCellEditorValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean stopCellEditing() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancelCellEditing() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
