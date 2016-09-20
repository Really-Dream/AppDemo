package com.dream.servlet;


import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.dream.help.Resulter;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class SimpleExcelWrite {
    public  void createExcel(OutputStream os,List<Resulter> list) throws WriteException,IOException{
        //创建工作薄
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //创建新的一页
        WritableSheet sheet = workbook.createSheet("First Sheet",0);
        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
        Label xuexiao = new Label(0,0,"用户ID");
        sheet.addCell(xuexiao);
        Label zhuanye = new Label(1,0,"用户姓名");
        sheet.addCell(zhuanye);
        Label jingzhengli = new Label(2,0,"成绩");
        sheet.addCell(jingzhengli);
        Label settime = new Label(3,0,"测试时间");
        sheet.addCell(settime);
        Label org = new Label(4,0,"组织");
        sheet.addCell(org);
        int i = 1;
        for(Resulter l:list){
        	Label qinghua = new Label(0,i,l.getUserid());
        	sheet.addCell(qinghua);
        	Label jisuanji = new Label(1,i,l.getUsername());
        	sheet.addCell(jisuanji);
        	Label gao = new Label(2,i,l.getGrade());
        	sheet.addCell(gao);
        	Label setime = new Label(3,i,l.getSettime());
        	sheet.addCell(setime);
        	Label Org = new Label(4,i,l.getOrg());
        	sheet.addCell(Org);
        	i++;
        }
        
//        Label beida = new Label(0,2,"北京大学");
//        sheet.addCell(beida);
//        Label falv = new Label(1,2,"法律专业");
//        sheet.addCell(falv);
//        Label zhong = new Label(2,2,"中");
//        sheet.addCell(zhong);
//        
//        Label ligong = new Label(0,3,"北京理工大学");
//        sheet.addCell(ligong);
//        Label hangkong = new Label(1,3,"航空专业");
//        sheet.addCell(hangkong);
//        Label di = new Label(2,3,"低");
//        sheet.addCell(di);
//        
        //把创建的内容写入到输出流中，并关闭输出流
        workbook.write();
        workbook.close();
        os.close();
    }
    
}
