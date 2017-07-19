package com.Jay.utils;


import java.util.TimerTask;

/**
 * @author Jay
 * @version 1.0
 * Created  on 2017-06-25.
 */
public class MyTimerTask extends TimerTask {
    private MyJFrame m;
    public MyTimerTask(MyJFrame m) {
        this.m=m;

    }

    @Override
    public void run() {
        m.i=m.i+1;
        m.repaint();
    }


}
