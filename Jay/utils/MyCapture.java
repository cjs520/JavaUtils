/**
 *
 */
package com.Jay.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;



/**
 * 这是一个屏幕截屏类
 * @author Jay
 *@version 1.0
 * 2017年6月18日下午3:37:26
 */

public class MyCapture {

    int width;
    int height;
    String filename;
    /**
     *
     * @param width 宽度
     * @param height 高度
     * @param filename 要保存的文件名以.jpg 结尾
     */
    public MyCapture(int width, int height, String filename) {
        this.width = width;
        this.height = height;
        this.filename = filename;
    }
    /**
     * 屏幕截屏方法
     * @throws Exception
     */
    public void cap() throws Exception{
        Robot r=new Robot();
        Rectangle rect=new Rectangle(width,height);
        BufferedImage bi=r.createScreenCapture(rect);
        File f=new File(filename);
        ImageIO.write(bi, "jpg", f);
    }


}
