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
package com.stripbandunk.jwidget.event;

import java.util.EventObject;
import com.stripbandunk.jwidget.model.PaginationModel;

/**
 *
 * @author echo
 */
public class PaginationModelEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    private PaginationAction actionType;

    public PaginationModelEvent(PaginationModel source, PaginationAction actionType) {
        super(source);
        this.actionType = actionType;
    }

    @Override
    public PaginationModel getSource() {
        return (PaginationModel) super.getSource();
    }

    public PaginationAction getActionType() {
        return actionType;
    }

    public int getTotalPage() {
        return getSource().getTotalPage();
    }

    public int getPageSize() {
        return getSource().getPageSize();
    }

    public int getCurrentPage() {
        return getSource().getCurrentPage();
    }
}
