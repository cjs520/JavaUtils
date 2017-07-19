package com.Jay.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Jay
 * @version 1.0
 * Created  on 2017-06-24.
 */
public class MyExcel {
    public void doexcel(String[] data, File file) throws  Exception{

        //新建工作簿
        HSSFWorkbook workb=new HSSFWorkbook();
        //建一个工作表
        HSSFSheet sheet=workb.createSheet("第一页");
        for (int i = 0; i <data.length ; i++) {
            sheet.setColumnWidth(i,5000);
        }


        //建立一行
        HSSFRow row=sheet.createRow(0);
        //建立单元格
        for (int i = 0; i <data.length ; i++) {
            HSSFCell hc=row.createCell(i);
            hc.setCellValue(data[i]);
        }



        workb.write(new FileOutputStream(file));

    }


}
