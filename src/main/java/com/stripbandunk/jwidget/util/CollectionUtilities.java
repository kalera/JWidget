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
package com.stripbandunk.jwidget.util;

import java.util.Collection;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@SuppressWarnings("FinalClass")
public final class CollectionUtilities {

    /**
     * Move objects from collection to other collection
     * @param <T>
     * @param from source collection
     * @param to target collection
     * @param switchObjects
     */
    public static <T> void moveObject(Collection<T> from, Collection<T> to, T[] switchObjects) {
        for (T object : switchObjects) {
            CollectionUtilities.moveObject(from, to, object);
        }
    }

    /**
     * Move object from collection to other collection
     * @param <T>
     * @param from source collection
     * @param to target collection
     * @param switchObject
     */
    public static <T> void moveObject(Collection<T> from, Collection<T> to, T switchObject) {
        if (from.contains(switchObject)) {
            to.add(switchObject);
            from.remove(switchObject);
        }
    }

    /**
     * Remove all object from collection to other collection
     * @param <T>
     * @param from source collection
     * @param to target collection
     */
    public static <T> void moveAllObject(Collection<T> from, Collection<T> to) {
        if (!from.isEmpty()) {
            to.addAll(from);
            from.clear();
        }
    }

    private CollectionUtilities() {
        // utilities class
    }
}
