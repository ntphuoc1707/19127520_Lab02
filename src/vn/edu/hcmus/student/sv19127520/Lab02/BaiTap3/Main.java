package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap3;

import vn.edu.hcmus.student.sv19127520.Lab02.BaiTap1.*;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 23/10/2021 - 9:13 CH
 * Description: ...
 */
public class Main {
    public static void main(String[] args){
        MangRangCua x=new MangRangCua();
        System.out.println("Phuong thuc nhap: ");
        x.Input();
        System.out.println("Phuong thuc xuat: ");
        x.Print();
        MangRangCua y= new MangRangCua(new MangMotChieu(1, 2),new MangMotChieu(4,1,2), new MangMotChieu(3,2));
        x.set(y);
        System.out.println("Set mang rang cua: ");
        x.Print();
        System.out.println("Get mang rang cua: ");
        MangRangCua t=new MangRangCua(x.get());
        t.Print();
        x.sortAscendRow();
        System.out.println("Sap xep tang dan theo dong: ");
        x.Print();
        x.delete(2);
        System.out.println("Xoa dong thu 2: ");
        x.Print();
        MangRangCua z=MangRangCua.parseMangRangCua("2 1, 4 5 1, 1 3");
        System.out.println("Parse mang rang cua tu chuoi: ");
        z.Print();
    }
}
