package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap5;
import vn.edu.hcmus.student.sv19127520.Lab02.BaiTap4.*;

import java.util.*;
/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 25/10/2021 - 3:50 CH
 * Description: ...
 */
public class Main {
    public static void main(String[] args) {
        MangPhanSo y=new MangPhanSo(new PhanSo(1,2), new PhanSo(3,4), new PhanSo(5,6));
        MangPhanSo z=MangPhanSo.parseMangPhanSo("5/6 7/3 4/5");
        System.out.print("Lay mang phan so: ");
        MangPhanSo x= new MangPhanSo(y.get());
        x.Print();
        System.out.print("Dat lai mang phan so: ");
        x.set(z);
        x.Print();
        x = new MangPhanSo();
        System.out.println("Phuong thuc nhap: ");
        x.Input();
        System.out.print("Phuong thuc xuat: ");
        x.Print();
        System.out.println();
        System.out.println("Tong mang phan so: "+x.Sum());
        System.out.println("Tich mang phan so: "+x.Product());
        System.out.println("Phan so lon nhat la: "+x.Max().toString());
        System.out.print("Vi tri co phan so lon nhat: ");
        Set<Integer> t= x.findMaxPos();
        for (Integer i:t){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("Rut gon mang so: ");
        x.compact();
        x.Print();
        System.out.print("Sap xep mang tang dan: ");
        x.sortAscend();
        x.Print();
        System.out.print("Sap xep mang giam dan: ");
        x.sortDescend();
        x.Print();
        System.out.print("Cap nhat phan so thu 1 =4/5: ");
        x.Update(1, new PhanSo(4,5));
        x.Print();
        System.out.print("Them 6/7 vao vi tri thu 2: ");
        x.Insert(2, new PhanSo(6,7));
        x.Print();
        System.out.print("Xoa phan so thu 0: ");
        x.delete(0);
        x.Print();
        System.out.println("Parse MangPhanSo tu chuoi: ");
        MangPhanSo p=MangPhanSo.parseMangPhanSo("13/2 5/4 8/3 5/7 4/7");
        p.Print();
    }

}
