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

import javax.swing.event.EventListenerList;
import com.stripbandunk.jwidget.event.PaginationAction;
import com.stripbandunk.jwidget.event.PaginationModelEvent;
import com.stripbandunk.jwidget.listener.PaginationModelListener;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public abstract class AbstractPaginationModel implements PaginationModel {

    @SuppressWarnings("ProtectedField")
    protected EventListenerList listenerList = new EventListenerList();

    private int currentPage = 1;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return (int) Math.ceil((double) getTotalItem() / (double) getPageSize());
    }

    public boolean isFirstPage() {
        return getCurrentPage() <= 1;
    }

    public boolean isLastPage() {
        return getCurrentPage() >= getTotalPage();
    }

    public boolean isHasNextPage() {
        return getCurrentPage() < getTotalPage();
    }

    public boolean isHasPrevPage() {
        return getCurrentPage() > 1;
    }

    public void nextPage() {
        if (isHasNextPage()) {
            changePage(getCurrentPage() + 1);
            firePaginationModelListenerOnPageChange(new PaginationModelEvent(this, PaginationAction.ACTION_NEXT_PAGE));
        }
    }

    public void prevPage() {
        if (isHasPrevPage()) {
            changePage(getCurrentPage() - 1);
            firePaginationModelListenerOnPageChange(new PaginationModelEvent(this, PaginationAction.ACTION_PREV_PAGE));
        }
    }

    public void firstPage() {
        changePage(1);
        firePaginationModelListenerOnPageChange(new PaginationModelEvent(this, PaginationAction.ACTION_FIRST_PAGE));
    }

    public void lastPage() {
        changePage(getTotalPage());
        firePaginationModelListenerOnPageChange(new PaginationModelEvent(this, PaginationAction.ACTION_LAST_PAGE));
    }

    public void goToPage(int page) {
        changePage(page);
        firePaginationModelListenerOnPageChange(new PaginationModelEvent(this, PaginationAction.ACTION_GOTO_PAGE));
    }

    private void changePage(int page) {
        currentPage = page;
    }

    public void addPaginationModelListener(PaginationModelListener listener) {
        listenerList.add(PaginationModelListener.class, listener);
    }

    public void removePaginationModelListener(PaginationModelListener listener) {
        listenerList.remove(PaginationModelListener.class, listener);
    }

    protected void firePaginationModelListenerOnPageChange(PaginationModelEvent event) {
        for (PaginationModelListener listener : listenerList.getListeners(PaginationModelListener.class)) {
            listener.onPageChange(event);
        }
    }
}
