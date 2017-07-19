package com.Jay.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Jay
 * @version 1.0
 * Created  on 2017-06-25.
 */
public class MyJFrame extends JFrame {
    private int x;
    private int y;
    public int i=100;
    public MyJFrame(int x, int y) throws HeadlessException {
        this.x = x;
        this.y = y;
        super.setSize(x,y);
        super.setVisible(true);

        MyTimerTask m=new MyTimerTask(this);
        new java.util.Timer().schedule(m,1000,200);
    }
    //Windows
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage bi;
        try {
            bi = ImageIO.read(new File("d:/Koala.jpg"));
            g.drawImage(bi,i,100,this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
