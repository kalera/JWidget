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
package khannedy.jwidget.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import khannedy.jwidget.editor.NoTableCellEditor;
import khannedy.jwidget.renderer.NoTableCellRenderer;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableColumn {

    int number();

    String name();

    boolean editable() default false;

    String[] groups() default {};

    Class<? extends TableCellRenderer> renderer() default NoTableCellRenderer.class;

    Class<? extends TableCellEditor> editor() default NoTableCellEditor.class;
}
