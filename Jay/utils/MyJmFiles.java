package com.Jay.utils;

import java.io.File;

/**
 * 这是一个加密文件夹下特定后缀类
 * @author Jay
 * @version 1.0
 * Created  on 2017-06-24.
 */
public class MyJmFiles {

    private File root;
    private int pass;
    /**
     *
     * @param root 文件名
     * @param pass 加密密码
     *
     */
    public MyJmFiles(File root, int pass) {
        this.root = root;
        this.pass = pass;
    }
    /**
     * 加密方法
     * @throws Exception
     */
    public  void jmfiles() throws Exception{
        pfile(root);
    }
    private  void pfile(File f) throws Exception{
        File[] ff=f.listFiles();
        for (int i = 0; i <ff.length ; i++) {
            if(ff[i].isDirectory()){
                pfile(ff[i]);
            }else {
                if (ff[i].getName().endsWith(".xlsx")){
                    //单文件加密
                    new Myls(ff[i],pass).jm();
                }

            }
        }
    }


}
