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

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import khannedy.jwidget.event.PaginationEvent;
import khannedy.jwidget.event.PaginationModelEvent;
import khannedy.jwidget.listener.PaginationListener;
import khannedy.jwidget.listener.PaginationModelListener;
import khannedy.jwidget.model.PaginationModel;
import khannedy.jwidget.util.ImageUtilities;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public final class JPagination extends JPanel implements PaginationModelListener, ActionListener, ItemListener {

    private JButton buttonFirst, buttonPrev, buttonNext, buttonLast;

    private JComboBox comboPage;

    protected PaginationModel model;

    public static final String PROP_MODEL = "model";

    public JPagination() {
        initComponent();
        renderComponent();
    }

    private void initComponent() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonFirst = new JButton();
        buttonFirst.addActionListener(this);
        buttonPrev = new JButton();
        buttonPrev.addActionListener(this);

        add(buttonFirst);
        add(buttonPrev);
        add(new JSeparator(JSeparator.VERTICAL));

        comboPage = new JComboBox();
        comboPage.addItemListener(this);
        add(comboPage);
        add(new JSeparator(JSeparator.VERTICAL));

        buttonNext = new JButton();
        buttonNext.addActionListener(this);
        buttonLast = new JButton();
        buttonLast.addActionListener(this);
        add(buttonNext);
        add(buttonLast);

        // change to default icon
        setIconFirst(ImageUtilities.getIcon("/khannedy/jwidget/resource/go_first.png"));
        setIconLast(ImageUtilities.getIcon("/khannedy/jwidget/resource/go_last.png"));
        setIconNext(ImageUtilities.getIcon("/khannedy/jwidget/resource/go_next.png"));
        setIconPrev(ImageUtilities.getIcon("/khannedy/jwidget/resource/go_previous.png"));
    }

    protected void renderComponent() {
        if (model == null) {
            buttonFirst.setEnabled(false);
            buttonLast.setEnabled(false);
            buttonNext.setEnabled(false);
            buttonPrev.setEnabled(false);
            comboPage.setEnabled(false);
        } else {
            buttonFirst.setEnabled(!model.isFirstPage());
            buttonLast.setEnabled(!model.isLastPage());
            buttonNext.setEnabled(model.isHasNextPage());
            buttonPrev.setEnabled(model.isHasPrevPage());
            comboPage.setEnabled(true);
        }
    }

    protected void refreshPagination() {
        comboPage.removeAllItems();
        for (int i = 1; i <= model.getTotalPage(); i++) {
            comboPage.addItem(i);
        }
    }

    /**
     * Get the value of model
     *
     * @return the value of model
     */
    public PaginationModel getModel() {
        return model;
    }

    /**
     * Set the value of model
     *
     * @param model new value of model
     */
    public void setModel(PaginationModel model) {
        if (model == null) {
            throw new IllegalArgumentException("PagiationModel is null");
        }

        PaginationModel oldModel = this.model;
        if (oldModel != null) {
            oldModel.removePaginationModelListener(this);
        }

        this.model = model;
        this.model.addPaginationModelListener(this);

        firePropertyChange(PROP_MODEL, oldModel, model);

        renderComponent();
        refreshPagination();
    }

    public void onPageChange(PaginationModelEvent event) {
        renderComponent();
        comboPage.setSelectedItem(event.getCurrentPage());
        fireOnPageChange(new PaginationEvent(this, event.getActionType()));
    }

    public void addPaginationListener(PaginationListener listener) {
        listenerList.add(PaginationListener.class, listener);
    }

    public void removePaginationListener(PaginationListener listener) {
        listenerList.remove(PaginationListener.class, listener);
    }

    protected void fireOnPageChange(PaginationEvent event) {
        for (PaginationListener listener : listenerList.getListeners(PaginationListener.class)) {
            listener.onPageChange(event);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonFirst) {
            model.firstPage();
        } else if (e.getSource() == buttonLast) {
            model.lastPage();
        } else if (e.getSource() == buttonNext) {
            model.nextPage();
        } else if (e.getSource() == buttonPrev) {
            model.prevPage();
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboPage) {
            if (Integer.valueOf(comboPage.getSelectedItem().toString()) != model.getCurrentPage()) {
                model.goToPage(Integer.valueOf(comboPage.getSelectedItem().toString()));
            }
        }
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(isOpaque);
        if (buttonFirst != null
                && buttonLast != null
                && buttonNext != null
                && buttonPrev != null
                && comboPage != null) {
            buttonFirst.setOpaque(isOpaque);
            buttonLast.setOpaque(isOpaque);
            buttonNext.setOpaque(isOpaque);
            buttonPrev.setOpaque(isOpaque);
            comboPage.setOpaque(isOpaque);
        }
    }

    public void setIconFirst(Icon defaultIcon) {
        buttonFirst.setIcon(defaultIcon);
    }

    public void setIconLast(Icon defaultIcon) {
        buttonLast.setIcon(defaultIcon);
    }

    public void setIconNext(Icon defaultIcon) {
        buttonNext.setIcon(defaultIcon);
    }

    public void setIconPrev(Icon defaultIcon) {
        buttonPrev.setIcon(defaultIcon);
    }

    public Icon getIconFirst() {
        return buttonFirst.getIcon();
    }

    public Icon getIconLast() {
        return buttonLast.getIcon();
    }

    public Icon getIconNext() {
        return buttonNext.getIcon();
    }

    public Icon getIconPrev() {
        return buttonPrev.getIcon();
    }
}
