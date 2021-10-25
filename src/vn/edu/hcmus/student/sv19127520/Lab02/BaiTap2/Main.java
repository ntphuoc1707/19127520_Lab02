package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap2;
import vn.edu.hcmus.student.sv19127520.Lab02.BaiTap1.*;
/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 23/10/2021 - 3:54 CH
 * Description: ...
 */
public class Main {
    public static void main(String[] args){
        MangHaiChieu x=new MangHaiChieu();
        System.out.println("Phuong thuc nhap: ");
        x.Input();
        System.out.println("Phuong thuc xuat: ");
        x.Print();
        x.sortRowAscend();
        System.out.println("Sap xep mang tang theo dong: ");
        x.Print();
        x.sortColDescend();
        System.out.println("Sap xep mang giam theo cot: ");
        x.Print();
        System.out.println("Tong cac phan tu: "+x.Sum());
        System.out.println("Tich cac phan tu: "+x.Product());
        System.out.println("Phan tu lon nhat: "+x.Max());
        System.out.println("Phan tu nguyen duong nho nhat: "+x.minPos());
        System.out.println("Phan tu nguyen am lon nhat: "+x.maxNeg());
        System.out.println("Dong co tong lon nhat: "+x.findMaxSumRow());
        System.out.println("Cot co tong lon nhat: "+x.findMaxSumCol());
        x.addHeadRow(new MangMotChieu(1,2,3).get());
        System.out.println("Them dong vao dau dong: ");
        x.Print();
        x.addTailRow(new MangMotChieu(1,2,3).get());
        System.out.println("Them dong vao cuoi dong: ");
        x.Print();
        x.addRowAt(new MangMotChieu(1,2,3).get(),1);
        System.out.println("Them dong vao vi tri thu 1");
        x.Print();
        x.deleteRow(2);
        System.out.println("Xoa dong 2:");
        x.Print();
        x.deleteCol(1);
        System.out.println("Xoa cot 1: ");
        x.Print();
        System.out.println("Copy mang: ");
        MangHaiChieu y=new MangHaiChieu();
        y.copy(x);
        y.Print();
        System.out.println("Parse mang 2 chieu tu chuoi: ");
        MangHaiChieu z=MangHaiChieu.parseMangHaiChieu("1 2, 3 4, 5 6, 12 2");
        z.Print();

    }
}
