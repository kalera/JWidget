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
package khannedy.jwidget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class JButtonPopup extends JToggleButton implements ActionListener, PopupMenuListener {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("ProtectedField")
    protected JPopupMenu popupMenu = new JPopupMenu();

    //<editor-fold defaultstate="collapsed" desc="Override Constructor">
    public JButtonPopup(String text, Icon icon) {
        super(text, icon);
        initComponent();
    }

    public JButtonPopup(Action a) {
        super(a);
        initComponent();
    }

    public JButtonPopup(String text) {
        super(text);
        initComponent();
    }

    public JButtonPopup(Icon icon) {
        super(icon);
        initComponent();
    }

    public JButtonPopup() {
        initComponent();
    }
    //</editor-fold>

    private void initComponent() {
        addActionListener(this);
        popupMenu.addPopupMenuListener(this);
    }

    public JMenuItem addMenuItem(Action action) {
        return popupMenu.add(action);
    }

    public JMenuItem addMenuItem(String text) {
        return popupMenu.add(text);
    }

    public JMenuItem addMenuItem(JMenuItem menuItem) {
        return popupMenu.add(menuItem);
    }

    public void removeMenuItem(JMenuItem menuItem) {
        popupMenu.remove(menuItem);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            popupMenu.show(this, 0, getHeight());
        }
    }

    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        if (e.getSource() == popupMenu) {
            setSelected(true);
        }
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        if (e.getSource() == popupMenu) {
            setSelected(false);
        }
    }

    public void popupMenuCanceled(PopupMenuEvent e) {
        if (e.getSource() == popupMenu) {
            setSelected(false);
        }
    }
}
