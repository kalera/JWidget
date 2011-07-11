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
import khannedy.jwidget.event.TimeLabelEvent;
import khannedy.jwidget.listener.TimeLabelListener;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class JTimeLabel extends JLabel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private String timeFormatter;

    public static final String DEFAULT_TIME_FORMATTER = "HH:mm:ss";

    public static final String PROP_TIME_FORMATTER = "timeFormatter";

    private Timer timer;

    public static final String PROP_DELAY = "delay";

    private Date now;

    private DateFormat format;

    public JTimeLabel() {
        this(1000, JTimeLabel.DEFAULT_TIME_FORMATTER);
    }

    public JTimeLabel(int delay) {
        this(delay, JTimeLabel.DEFAULT_TIME_FORMATTER);
    }

    public JTimeLabel(int delay, String timeFormatter) {
        this.timeFormatter = timeFormatter;

        now = new Date();
        timer = new Timer(delay, this);
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

    private TimeLabelEvent event = new TimeLabelEvent(this);

    public void startTimer() {
        timer.start();
        fireTimeLabelListenerOnStart(event);
    }

    public void stopTimer() {
        timer.stop();
        fireTimeLabelListenerOnStop(event);
    }

    public void actionPerformed(ActionEvent e) {
        renderTime();
        fireTimeLabelListenerOnTimeChange(event);
    }

    public long getTime() {
        return now.getTime();
    }

    public void addTimeLabelListener(TimeLabelListener listener) {
        listenerList.add(TimeLabelListener.class, listener);
    }

    public void removeTimeLabelListener(TimeLabelListener listener) {
        listenerList.remove(TimeLabelListener.class, listener);
    }

    protected void fireTimeLabelListenerOnStart(TimeLabelEvent event) {
        for (TimeLabelListener listener : listenerList.getListeners(TimeLabelListener.class)) {
            listener.onStart(event);
        }
    }

    protected void fireTimeLabelListenerOnStop(TimeLabelEvent event) {
        for (TimeLabelListener listener : listenerList.getListeners(TimeLabelListener.class)) {
            listener.onStop(event);
        }
    }

    protected void fireTimeLabelListenerOnTimeChange(TimeLabelEvent event) {
        for (TimeLabelListener listener : listenerList.getListeners(TimeLabelListener.class)) {
            listener.onTimeChange(event);
        }
    }
}
