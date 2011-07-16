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
package khannedy.jwidget.listener;

import khannedy.jwidget.event.DoubleListEvent;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public abstract class AbstractDoubleListListener implements DoubleListListener {

    @SuppressWarnings("NoopMethodInAbstractClass")
    public void onAdd(DoubleListEvent event) {
        // abstract class
    }

    @SuppressWarnings("NoopMethodInAbstractClass")
    public void onRemove(DoubleListEvent event) {
        // abstract class
    }

    @SuppressWarnings("NoopMethodInAbstractClass")
    public void onAddAll(DoubleListEvent event) {
        // abstract class
    }

    @SuppressWarnings("NoopMethodInAbstractClass")
    public void onRemoveAll(DoubleListEvent event) {
        // abstract class
    }
}