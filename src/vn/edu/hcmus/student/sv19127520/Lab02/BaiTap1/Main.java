package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap1;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 23/10/2021 - 1:15 CH
 * Description: ...
 */
public class Main {
    public static void main(String[] args) {
        MangMotChieu x=new MangMotChieu();
        System.out.println("Phuong thuc nhap: ");
        x.Input();
        System.out.print("Phuong thuc xuat: ");
        x.Print();
        System.out.println();
        MangMotChieu p=MangMotChieu.copy(x);
        System.out.print("Lay mang: ");
        for(int i:x.get()){
            System.out.print(i+" ");
        }
        System.out.println();
        int[]a={1,2,3,4};
        x.set(a);
        System.out.print("Set mang thanh 1 2 3 4: ");
        x.Print();
        System.out.println();
        x=MangMotChieu.copy(p);
        System.out.print("Mang tang dan: ");
        x.sortAscend();
        x.Print();
        System.out.println();
        System.out.print("Mang giam dan: ");
        x.sortDescend();
        x.Print();
        System.out.println();
        System.out.println("Tong cac phan tu: "+x.Sum());
        System.out.println("Tich cac phan tu: "+x.Product());
        System.out.println("So nguyen lon nhat: "+x.Max());
        System.out.println("So nguyen duong nho nhat: "+x.minPos());
        System.out.println("So nguyen am lon nhat: "+x.maxNeg());
        x.addHead(5);
        System.out.print("Them 5 vao dau mang: ");
        x.Print();
        System.out.println();
        x.addTail(4);
        System.out.print("Them 4 vao cuoi mang: ");
        x.Print();
        System.out.println();
        x.add(2,3);
        System.out.print("Them 3 vao vi tri thu 2: ");
        x.Print();
        System.out.println();
        x.delete(1);
        System.out.print("Xoa phan tu thu 1: ");
        x.Print();
        System.out.println();
        x.deleteVal(4);
        System.out.print("Xoa cac phan tu bang 4: ");
        x.Print();
        System.out.println();
        x.updateAt(1,2);
        System.out.print("Cap nhat phan tu thu 1 = 2: ");
        x.Print();
        System.out.println();
        x.updateVal(3,7);
        System.out.print("Cap nhat gia tri 3 thanh 7: ");
        x.Print();
        System.out.println();
        MangMotChieu y=MangMotChieu.parseMangSoNguyen("4 5 2 5 9 77 12 3");
        System.out.print("Parse MangSoNguyen tu chuoi: ");
        y.Print();
        System.out.println();
        MangMotChieu t= MangMotChieu.Merge(x,y);
        System.out.print("Gop mang vua parse voi mang cua ban: ");
        t.Print();
        System.out.println();
        MangMotChieu z=MangMotChieu.copy(x);
        System.out.print("Copy mang hien tai: ");
        z.Print();
        System.out.println();
        z.reset(1);
        System.out.print("Set tat ca cac phan tu ve 1: ");
        z.Print();
    }
}
