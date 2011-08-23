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
import com.stripbandunk.jwidget.JDoubleList;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class DoubleListEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    private Object[] values;

    public DoubleListEvent(JDoubleList source, Object[] values) {
        super(source);
        this.values = values;
    }

    public Object[] getValues() {
        return this.values;
    }

    @Override
    public JDoubleList getSource() {
        return (JDoubleList) super.getSource();
    }
}
