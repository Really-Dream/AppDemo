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
        //����������
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //�����µ�һҳ
        WritableSheet sheet = workbook.createSheet("First Sheet",0);
        //����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
        Label xuexiao = new Label(0,0,"�û�ID");
        sheet.addCell(xuexiao);
        Label zhuanye = new Label(1,0,"�û�����");
        sheet.addCell(zhuanye);
        Label jingzhengli = new Label(2,0,"�ɼ�");
        sheet.addCell(jingzhengli);
        Label settime = new Label(3,0,"����ʱ��");
        sheet.addCell(settime);
        Label org = new Label(4,0,"��֯");
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
        
//        Label beida = new Label(0,2,"������ѧ");
//        sheet.addCell(beida);
//        Label falv = new Label(1,2,"����רҵ");
//        sheet.addCell(falv);
//        Label zhong = new Label(2,2,"��");
//        sheet.addCell(zhong);
//        
//        Label ligong = new Label(0,3,"��������ѧ");
//        sheet.addCell(ligong);
//        Label hangkong = new Label(1,3,"����רҵ");
//        sheet.addCell(hangkong);
//        Label di = new Label(2,3,"��");
//        sheet.addCell(di);
//        
        //�Ѵ���������д�뵽������У����ر������
        workbook.write();
        workbook.close();
        os.close();
    }
    
}
