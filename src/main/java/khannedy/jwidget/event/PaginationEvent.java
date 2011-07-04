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
package khannedy.jwidget.event;

import java.util.EventObject;
import khannedy.jwidget.JPagination;

/**
 *
 * @author echo
 */
public class PaginationEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    private PaginationAction actionType;

    public PaginationEvent(JPagination source, PaginationAction actionType) {
        super(source);
        this.actionType = actionType;
    }

    @Override
    public JPagination getSource() {
        return (JPagination) super.getSource();
    }

    public PaginationAction getActionType() {
        return actionType;
    }

    public int getCurrentPage() {
        return getSource().getModel().getCurrentPage();
    }

    public int getTotalPage() {
        return getSource().getModel().getTotalPage();
    }

    public int getTotalItem() {
        return getSource().getModel().getTotalItem();
    }

    public int getPageSize() {
        return getSource().getModel().getPageSize();
    }
}
