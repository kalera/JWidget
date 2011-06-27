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
package khannedy.jwidget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class JTimeLabel extends JLabel implements ActionListener {

    private String timeFormatter = "HH:mm:ss";

    public static final String PROP_TIME_FORMATTER = "timeFormatter";

    private Timer timer;

    public static final String PROP_DELAY = "delay";

    private Date now = new Date();

    private DateFormat format;

    public JTimeLabel() {
        initComponent();
    }

    private void initComponent() {
        timer = new Timer(1000, this);
        format = new SimpleDateFormat(timeFormatter);

        renderTime();
    }

    private void renderTime() {
        now.setTime(System.currentTimeMillis());
        setText(format.format(now));
    }

    /**
     * Get the value of delay
     *
     * @return the value of delay
     */
    public int getDelay() {
        return timer.getDelay();
    }

    /**
     * Set the value of delay
     *
     * @param delay new value of delay
     */
    public void setDelay(int delay) {
        int oldDelay = timer.getDelay();
        timer.setDelay(delay);
        firePropertyChange(PROP_DELAY, oldDelay, delay);
    }

    /**
     * Get the value of timeFormatter
     *
     * @return the value of timeFormatter
     */
    public String getTimeFormatter() {
        return timeFormatter;
    }

    /**
     * Set the value of timeFormatter
     *
     * @param timeFormatter new value of timeFormatter
     */
    public void setTimeFormatter(String timeFormatter) {
        String oldTimeFormatter = this.timeFormatter;
        this.timeFormatter = timeFormatter;

        format = new SimpleDateFormat(timeFormatter);
        renderTime();

        firePropertyChange(PROP_TIME_FORMATTER, oldTimeFormatter, timeFormatter);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        renderTime();
    }
}
