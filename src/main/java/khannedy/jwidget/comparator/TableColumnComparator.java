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
package khannedy.jwidget.comparator;

import java.lang.reflect.Field;
import java.util.Comparator;
import khannedy.jwidget.annotation.TableColumn;

/**
 *
 * @author echo
 */
public class TableColumnComparator implements Comparator<Field> {

    public int compare(Field o1, Field o2) {
        TableColumn column1 = o1.getAnnotation(TableColumn.class);
        TableColumn column2 = o2.getAnnotation(TableColumn.class);
        return Integer.valueOf(column1.name()).compareTo(Integer.valueOf(column2.number()));
    }
}
