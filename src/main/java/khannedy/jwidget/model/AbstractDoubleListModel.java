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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.event.EventListenerList;
import khannedy.jwidget.event.DoubleListModelEvent;
import khannedy.jwidget.listener.DoubleListModelListener;

/**
 *
 * @param <T> 
 * @author Eko Kurniawan Khannedy
 */
public abstract class AbstractDoubleListModel<T> implements DoubleListModel<T> {

    private static final long serialVersionUID = 1L;

    private Class<T> dataClass;

    public AbstractDoubleListModel(Class<T> dataClass) {
        this.dataClass = dataClass;
    }

    public Class<T> getDataClass() {
        return dataClass;
    }

    public abstract void removeSourceValues(Collection<T> object);

    public abstract void removeTargetValues(Collection<T> object);

    public abstract void addSourceValues(Collection<T> object);

    public abstract void addTargetValues(Collection<T> object);

    public abstract void removeAllSourceValues();

    public abstract void removeAllTargetValues();

    private T[] convertToArray(List<T> list) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(dataClass, list.size());
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public T[] actionAdd(int[] index) {
        List<T> list = new ArrayList<T>(index.length);

        for (int i = 0; i < index.length; i++) {
            list.add(getSourceValue(index[i]));
        }

        removeSourceValues(list);
        fireSourceValuesRemove(list.toArray());

        addTargetValues(list);
        fireTargetValuesAdd(list.toArray());

        return convertToArray(list);
    }

    public T[] actionRemove(int[] index) {
        List<T> list = new ArrayList<T>(index.length);

        for (int i = 0; i < index.length; i++) {
            list.add(getTargetValue(index[i]));
        }

        removeTargetValues(list);
        fireTargetValuesRemove(list.toArray());

        addSourceValues(list);
        fireSourceValuesAdd(list.toArray());

        return convertToArray(list);
    }

    public T[] actionAddAll() {
        List<T> list = new ArrayList<T>(getSourceSize());
        for (int i = 0; i < getSourceSize(); i++) {
            list.add(getSourceValue(i));
        }

        addTargetValues(list);
        fireTargetValuesAdd(list.toArray());

        removeAllSourceValues();
        fireSourceValuesRemove(list.toArray());

        return convertToArray(list);
    }

    public T[] actionRemoveAll() {
        List<T> list = new ArrayList<T>(getTargetSize());
        for (int i = 0; i < getTargetSize(); i++) {
            list.add(getTargetValue(i));
        }

        addSourceValues(list);
        fireSourceValuesAdd(list.toArray());

        removeAllTargetValues();
        fireTargetValuesRemove(list.toArray());

        return convertToArray(list);
    }

    //<editor-fold defaultstate="collapsed" desc="Listeners">
    @SuppressWarnings("ProtectedField")
    protected final EventListenerList listenerList = new EventListenerList();

    public void addDoubleListModelListener(DoubleListModelListener listener) {
        listenerList.add(DoubleListModelListener.class, listener);
    }

    public void removeDoubleListModelListener(DoubleListModelListener listener) {
        listenerList.remove(DoubleListModelListener.class, listener);
    }

    protected void fireSourceValuesAdd(Object[] objects) {
        DoubleListModelEvent event = new DoubleListModelEvent(this, objects, DoubleListModelEvent.ACTION_ADD);
        for (DoubleListModelListener listener : listenerList.getListeners(DoubleListModelListener.class)) {
            listener.onSourceChanged(event);
        }
    }

    protected void fireSourceValuesRemove(Object[] objects) {
        DoubleListModelEvent event = new DoubleListModelEvent(this, objects, DoubleListModelEvent.ACTION_REMOVE);
        for (DoubleListModelListener listener : listenerList.getListeners(DoubleListModelListener.class)) {
            listener.onSourceChanged(event);
        }
    }

    protected void fireTargetValuesAdd(Object[] objects) {
        DoubleListModelEvent event = new DoubleListModelEvent(this, objects, DoubleListModelEvent.ACTION_ADD);
        for (DoubleListModelListener listener : listenerList.getListeners(DoubleListModelListener.class)) {
            listener.onTargetChanged(event);
        }
    }

    protected void fireTargetValuesRemove(Object[] objects) {
        DoubleListModelEvent event = new DoubleListModelEvent(this, objects, DoubleListModelEvent.ACTION_REMOVE);
        for (DoubleListModelListener listener : listenerList.getListeners(DoubleListModelListener.class)) {
            listener.onTargetChanged(event);
        }
    }

    protected void fireTargetValuesSet(Object[] objects, int[] indices) {
        DoubleListModelEvent event = new DoubleListModelEvent(this, DoubleListModelEvent.ACTION_SET, objects, indices);
        for (DoubleListModelListener listener : listenerList.getListeners(DoubleListModelListener.class)) {
            listener.onTargetChanged(event);
        }
    }

    protected void fireSourceValuesSet(Object[] objects, int[] indices) {
        DoubleListModelEvent event = new DoubleListModelEvent(this, DoubleListModelEvent.ACTION_SET, objects, indices);
        for (DoubleListModelListener listener : listenerList.getListeners(DoubleListModelListener.class)) {
            listener.onSourceChanged(event);
        }
    }
    //</editor-fold>
}
