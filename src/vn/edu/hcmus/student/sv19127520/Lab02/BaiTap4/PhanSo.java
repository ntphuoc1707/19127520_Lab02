package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap4;

import java.util.Scanner;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 23/10/2021 - 10:54 CH
 * Description: ...
 */
public class PhanSo {
    private int num;
    private int den;

    public PhanSo(){
        num=0;
        den=1;
    }
    public PhanSo(int x, int y){
        if(y==0){
            System.out.println("Invalid");
            num=0;
            den=1;
        }
        else {
            int k=GCD(x,y);
            num=x/k;
            den=y/k;
        }
    }
    public int getNum(){
        return num;
    }
    public int getDen(){
        return den;
    }
    public void set(int x, int y){
        if(y==0){
            System.out.println("Invalid");
            num=0;
            den=1;
        }
        else {
            int k=GCD(x,y);
            num=x/k;
            den=y/k;
        }
    }
    public void Input(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Numerator: ");
        int x=scan.nextInt();
        System.out.print("Denominator: ");
        int y=scan.nextInt();
        if(y==0){
            System.out.println("Denominator is invalid");
            return;
        }
        int k=GCD(x,y);
        num=x/k;
        den=y/k;
    }
    public void Print(){
        System.out.print(String.format("%d/%d",num,den));
    }
    public static int GCD(int a, int b)
    {
        if (a == 0)
            return b;
        return GCD(b%a, a);
    }
    public PhanSo compact(){
        int k=GCD(num,den);
        num/=k;
        den/=k;
        if(den<0) {
            den = -den;
            num =-num;
        }
        return new PhanSo(num,den);
    }
    public static PhanSo Add(PhanSo x, PhanSo y){
        if(x.den==0||y.den==0) {
            System.out.println("Invalid");
            return null;
        }
        PhanSo f=new PhanSo();
        f.num=x.num*y.den+y.num*x.den;
        f.den=x.den*y.den;
        f=f.compact();
        return f;
    }
    public static PhanSo Sub(PhanSo x, PhanSo y){
        if(x.den==0||y.den==0) {
            System.out.println("Invalid");
            return null;
        }
        PhanSo f=new PhanSo();
        f.num=x.num*y.den-y.num*x.den;
        f.den=x.den*y.den;
        f=f.compact();
        return f;
    }
    public static PhanSo Mul(PhanSo x, PhanSo y){
        if(x.den==0||y.den==0) {
            System.out.println("Invalid");
            return null;
        }
        PhanSo f=new PhanSo();
        f.num=x.num*y.num;
        f.den=x.den*y.den;
        f=f.compact();
        return f;
    }
    public static PhanSo Div(PhanSo x, PhanSo y) {
        if(x.den==0||y.den==0||y.num==0) {
            System.out.println("Invalid");
            return null;
        }
            PhanSo f = new PhanSo();
            f.num = x.num * y.den;
            f.den = x.den * y.num;
            f=f.compact();
            return f;
    }
    public static PhanSo parsePhanSo(String a){
        String[] t=a.split("/");
        if(t[1]=="0")
            return null;
        PhanSo x=new PhanSo(Integer.parseInt(t[0]),Integer.parseInt(t[1]));
        return x;
    }
    public String toString(){
        return String.valueOf(num)+"/"+String.valueOf(den);
    }
    public double value(){
        return (double)num/den;
    }
}
