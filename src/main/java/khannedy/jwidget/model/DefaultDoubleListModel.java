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
package khannedy.jwidget.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @param <T> 
 * @author Eko Kurniawan Khannedy
 */
public class DefaultDoubleListModel<T> extends AbstractDoubleListModel<T> {

    private static final long serialVersionUID = 1L;

    private List<T> source;

    private List<T> target;

    public DefaultDoubleListModel(Class<T> dataClass, T[] objects) {
        this(dataClass);
        source.addAll(Arrays.<T>asList(objects));
    }

    public DefaultDoubleListModel(Class<T> dataClass, List<T> source, List<T> target) {
        super(dataClass);
        this.source = source;
        this.target = target;
    }

    public DefaultDoubleListModel(Class<T> dataClass) {
        this(dataClass, new ArrayList<T>(0), new ArrayList<T>(0));
    }

    public void add(T data) {
        source.add(data);
        fireSourceValuesAdd(new Object[]{data});
    }

    public void add(T[] data) {
        source.addAll(Arrays.asList(data));
        fireSourceValuesAdd(data);
    }

    public void remove(T data) {
        source.remove(data);
        fireSourceValuesRemove(new Object[]{data});
    }

    public void remove(T[] data) {
        source.addAll(Arrays.asList(data));
        fireSourceValuesRemove(data);
    }

    public void set(int index, T data) {
        source.set(index, data);
        fireSourceValuesSet(new Object[]{data}, new int[]{index});
    }

    public void set(int[] indices, T[] data) {
        for (int i = 0; i < indices.length; i++) {
            source.set(indices[i], data[i]);
        }
        fireSourceValuesSet(data, indices);
    }

    @Override
    @SuppressWarnings("element-type-mismatch")
    public void removeSourceValues(Collection<T> object) {
        for (Object o : object) {
            source.remove(o);
        }
    }

    @Override
    @SuppressWarnings("element-type-mismatch")
    public void removeTargetValues(Collection<T> object) {
        for (Object o : object) {
            target.remove(o);
        }
    }

    @Override
    public void addSourceValues(Collection<T> object) {
        source.addAll(object);
    }

    @Override
    public void addTargetValues(Collection<T> object) {
        target.addAll(object);
    }

    @Override
    public void removeAllSourceValues() {
        source.clear();
    }

    @Override
    public void removeAllTargetValues() {
        target.clear();
    }

    @Override
    public int getSourceSize() {
        return source.size();
    }

    @Override
    public T getSourceValue(int index) {
        return source.get(index);
    }

    @Override
    public int getTargetSize() {
        return target.size();
    }

    @Override
    public T getTargetValue(int index) {
        return target.get(index);
    }

    @Override
    public Collection<T> getSources() {
        return Collections.unmodifiableCollection(source);
    }

    @Override
    public Collection<T> getValues() {
        return Collections.unmodifiableCollection(target);
    }

    @Override
    public int indexOf(T value) {
        return source.indexOf(value);
    }
}
