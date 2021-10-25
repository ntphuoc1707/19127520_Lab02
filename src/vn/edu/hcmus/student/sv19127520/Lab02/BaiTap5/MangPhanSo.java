package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap5;

import vn.edu.hcmus.student.sv19127520.Lab02.BaiTap4.PhanSo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 25/10/2021 - 3:50 CH
 * Description: ...
 */
public class MangPhanSo {
    private PhanSo[] arr;
    private int size;

    public MangPhanSo(){
        arr=null;
        size=0;
    }
    public MangPhanSo(PhanSo...arr){
        PhanSo[] t=new PhanSo[arr.length];
        for (int i=0;i<arr.length;i++){
            t[i]=arr[i];
        }
        this.arr=t;
        this.size=arr.length;
    }

    /**
     * Get method
     * @return PhanSo[]
     */
    public PhanSo[] get(){
        return this.arr;
    }

    /**
     * set method
     * @param a MangPhanSo
     */
    public void set(MangPhanSo a){
        this.arr=a.arr;
        this.size=a.size;
    }

    /**
     * Input method
     */
    public void Input(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter size: ");
        int n=scan.nextInt();
        if(n<=0){
            System.out.println("");
            return;
        }
        PhanSo[] s= new PhanSo[n];
        for (int i=0;i<n;i++){
            PhanSo t=new PhanSo();
            System.out.println("PhanSo "+i+": ");
            t.Input();
            s[i]=t;
        }
        this.arr=s;
        this.size=n;
    }

    /**
     * Display method
     */
    public void Print(){
        for (PhanSo i:this.arr){
            i.Print();
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * Sum of MangPhanSo
     * @return PhanSo
     */
    public PhanSo Sum(){
        PhanSo sum=new PhanSo();
        for (PhanSo i:this.arr){
            sum=PhanSo.Add(sum, i);
        }
        return sum;
    }

    /**
     * Product of MangPhanSo
     * @return product
     */
    public PhanSo Product(){
        if (this.size==0)
            return new PhanSo(0,1);
        PhanSo pro=new PhanSo(1,1);
        for (PhanSo i:this.arr){
            pro=PhanSo.Mul(pro, i);
        }
        return pro;
    }

    /**
     * Find maximum value
     * @return maximum value
     */
    public PhanSo Max(){
        if(this.size==0)
            return new PhanSo();
        double max=arr[0].value();
        PhanSo t=arr[0];
        for (int i=1;i<this.size;i++){
            double k=arr[i].value();
            if(max<k) {
                max = k;
                t=arr[i];
            }
        }
        return t;
    }

    /**
     * Find position of maximum value
     * @return Set<Integer></Integer>
     */
    public Set<Integer> findMaxPos(){
        PhanSo t=Max();
        Set<Integer> k =new HashSet<Integer>();
        for (int i=0;i<this.size;i++){
            double s= arr[i].value();
            if(Double.compare(s,t.value())==0){
                k.add(i);
            }
        }
        return k;
    }

    /**
     * Compact PhanSo
     */
    public void compact(){
        for (PhanSo i:arr){
            i=i.compact();
        }
    }

    /**
     * Sort ascending
     */
    public void sortAscend(){
        for (int i=0;i<this.size-1;i++){
            for (int j=i+1;j<this.size;j++){
                if(arr[i].value()>arr[j].value()){
                    PhanSo t= arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
    }

    /**
     * Sort descending
     */
    public void sortDescend(){
        for (int i=0;i<this.size-1;i++){
            for (int j=i+1;j<this.size;j++){
                if(arr[i].value()<arr[j].value()){
                    PhanSo t= arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
    }

    /**
     * Update value in position k
     * @param k position
     * @param a value
     */
    public void Update(int k, PhanSo a){
        if(k<0 ||k >this.size)
            return;
        this.arr[k]=a;
    }

    /**
     * Update value a in position k
     * @param k position
     * @param a value
     */
    public void Update(int k, String a){
        if(k<0 ||k >this.size)
            return;
        this.arr[k]=PhanSo.parsePhanSo(a);
    }

    /**
     * Insert method
     * @param k position
     * @param a value
     */
    public void Insert(int k, PhanSo a){
        if(k<0 ||k >this.size)
            return;
        PhanSo[] t= new PhanSo[this.size+1];
        for (int i=0;i<k;i++){
            t[i]=this.arr[i];
        }
        t[k]=a;
        for (int i=k;i<this.size;i++){
            t[i+1]=this.arr[i];
        }
        this.arr=t;
        this.size++;
    }

    /**
     * Delete method
     * @param k position
     */
    public void delete(int k){
        if(k<0 ||k >this.size)
            return;
        PhanSo[] t= new PhanSo[this.size-1];
        for (int i=0;i<k;i++){
            t[i]=this.arr[i];
        }
        for (int i=k+1;i<this.size;i++){
            t[i-1]=this.arr[i];
        }
        this.arr=t;
        this.size--;
    }

    /**
     * Parse from String to MangPhanSo
     * @param a string
     * @return MangPhanSo
     */
    public static MangPhanSo parseMangPhanSo(String a){
        String[] y=a.split(" ");
        MangPhanSo t=new MangPhanSo();
        for (String i:y){
            t.Insert(t.size, PhanSo.parsePhanSo(i));
        }
        return t;
    }
}
