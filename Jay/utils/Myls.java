package com.Jay.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 这是一个加密单文件类
 * @author Jay
 * @version 1.0
 * Created  on 2017-06-24.
 */
public class Myls {

    private File file;
    private int pass;
    /**
     *
     * @param file 文件名
     * @param pass 加密密码
     *
     */
    public Myls(File file,int pass){
        this.file=file;
        this.pass=pass;
    }
    /**
     * 加密方法
     * @throws Exception
     */
    public void jm()throws Exception{




            File temp=new File("d:/22.txt");
            //读，加密，写
            FileInputStream f= new FileInputStream(file);
            FileOutputStream fo =new FileOutputStream(temp);
            int c=-1;
            while((c=f.read() )!=-1){
                c=c^pass;
                fo.write(c);
            }
            f.close();
            fo.close();
            //删除与更名
            file.delete();
            temp.renameTo(file);

        }


}

