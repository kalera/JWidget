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
import khannedy.jwidget.model.DoubleListModel;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class DoubleListModelEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    public static final int ACTION_ADD = 1;

    public static final int ACTION_REMOVE = 2;

    public static final int ACTION_SET = 3;

    private int type;

    private Object[] values;

    private int[] Indices;

    public DoubleListModelEvent(DoubleListModel<?> source, int type, Object[] values, int[] Indices) {
        this(source, values, type);
        this.Indices = Indices;
    }

    public DoubleListModelEvent(DoubleListModel<?> source, Object[] values, int type) {
        super(source);
        this.values = values;
        this.type = type;
    }

    public int[] getIndices() {
        return Indices;
    }

    public Object[] getValues() {
        return values;
    }

    public int getType() {
        return type;
    }

    @Override
    public DoubleListModel<?> getSource() {
        return (DoubleListModel<?>) super.getSource();
    }
}
