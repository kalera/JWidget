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

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public enum PaginationAction {

    ACTION_NEXT_PAGE("Next Page"),
    ACTION_PREV_PAGE("Prev Page"),
    ACTION_FIRST_PAGE("First Page"),
    ACTION_LAST_PAGE("Last Page"),
    ACTION_GOTO_PAGE("Goto Page");

    private String action;

    private PaginationAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }
}
