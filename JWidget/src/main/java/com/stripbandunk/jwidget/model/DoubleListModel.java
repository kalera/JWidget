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

import java.io.Serializable;
import java.util.Collection;
import com.stripbandunk.jwidget.listener.DoubleListModelListener;

/**
 *
 * @param <T> 
 * @author Eko Kurniawan Khannedy
 */
public interface DoubleListModel<T> extends Serializable {

    void addDoubleListModelListener(DoubleListModelListener listener);

    void removeDoubleListModelListener(DoubleListModelListener listener);

    int getSourceSize();

    int indexOf(T value);

    T getSourceValue(int index);

    int getTargetSize();

    T getTargetValue(int index);

    T[] actionAdd(int[] index);

    T[] actionRemove(int[] index);

    T[] actionAddAll();

    T[] actionRemoveAll();

    Collection<T> getSources();

    Collection<T> getValues();
}
