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

import java.lang.reflect.Array;
import java.util.List;

/**
 *
 * @author echo
 */
@SuppressWarnings("FinalClass")
public final class ArrayUtilities {

    private ArrayUtilities() {
        // utilities class
    }

    public static boolean contains(Object[] objects, Object search) {
        for (Object object : objects) {
            if (object.equals(search)) {
                return true;
            }
        }
        return false;
    }

    public static <T> T[] convert(List<T> list, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, list.size());
        array = list.toArray(array);
        return array;
    }
}
