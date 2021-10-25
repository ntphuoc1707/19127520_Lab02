package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap4;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 23/10/2021 - 10:54 CH
 * Description: ...
 */
public class Main {
    public static void main(String[] args) {
        PhanSo x=new PhanSo();
        System.out.println("Phuong thuc nhap: ");
        x.Input();
        System.out.print("Phuong thuc xuat: ");
        x.Print();
        System.out.println("Lay tu so: "+x.getNum());
        System.out.println("Lay mau so: "+x.getDen());
        x.set(3,4);
        System.out.print("Set phan so thanh 3/4: ");
        x.Print();
        PhanSo y=new PhanSo(5,6);
        System.out.println(x.toString()+" + "+y.toString()+" = "+PhanSo.Add(x,y).toString());
        System.out.println(x.toString()+" - "+y.toString()+" = "+PhanSo.Sub(x,y).toString());
        System.out.println(x.toString()+" * "+y.toString()+" = "+PhanSo.Mul(x,y).toString());
        System.out.println(x.toString()+" / "+y.toString()+" = "+PhanSo.Div(x,y).toString());
        System.out.println("Rut gon 3/15 = "+new PhanSo(3,15).compact());
        System.out.println("Parse phan so tu chuoi: "+PhanSo.parsePhanSo("7/8"));
    }
}
