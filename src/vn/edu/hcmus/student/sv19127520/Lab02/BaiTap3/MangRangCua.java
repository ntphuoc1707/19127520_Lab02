package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap3;
import vn.edu.hcmus.student.sv19127520.Lab02.BaiTap1.*;

import java.util.Scanner;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 23/10/2021 - 9:13 CH
 * Description: ...
 */
public class MangRangCua {
    private MangMotChieu[] arr;
    private int size;

    public MangRangCua(){
        this.arr=null;
        this.size=0;
    }

    /**
     * Get method
     * @return MangMotChieu[]
     */
    public MangMotChieu[] get(){
        return this.arr;
    }
    public MangRangCua(MangMotChieu...arr){
        MangMotChieu[] t= new MangMotChieu[arr.length];
        for (int i=0;i<arr.length;i++){
            t[i]=arr[i];
        }
        this.arr=t;
        this.size=arr.length;
    }

    /**
     * Set method
     * @param a
     */
    public void set(MangRangCua a){
        this.arr=a.arr;
        this.size=a.size;
    }

    /**
     * Input method
     */
    public void Input(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter size: ");
        int s=scan.nextInt();
        if(s<0){
            System.out.println("Size is invalid");
            return;
        }
        MangMotChieu[] a=new MangMotChieu[s];
        for (int i=0;i<s;i++){
            MangMotChieu t=new MangMotChieu();
            System.out.println(String.format("In row %d :",i));
            t.Input();
            a[i]=t;
        }
        this.arr=a;
        this.size=s;
    }

    /**
     * Display MangRangCua
     */
    public void Print(){
        for (MangMotChieu i:this.arr){
            i.Print();
            System.out.println();
        }
    }

    /**
     * Sort ascending on each row
     */
    public void sortAscendRow(){
        for (MangMotChieu i: this.arr){
            i.sortAscend();
        }
    }

    /**
     * Sum elements of MangRangCua
     * @return Sum
     */
    public int Sum(){
        int sum=0;
        for (MangMotChieu i:this.arr){
            sum+=i.Sum();
        }
        return sum;
    }

    /**
     * Product elements of MangRangCua
     * @return product
     */
    public int Product(){
        int product=1;
        for (MangMotChieu i: this.arr){
            product*=i.Product();
        }
        return product;
    }

    /**
     * Find maximum value
     * @return maximum value
     */
    public int Max(){
        int max=this.arr[0].Max();
        for (int i=1;i<this.size;i++){
            int k=this.arr[i].Max();
            if(max<k)
                max=k;
        }
        return max;
    }

    /**
     * Find minimum value
     * @return minimum value
     */
    public int Min(){
        int min=this.arr[0].Min();
        for (int i=1;i<this.size;i++){
            int k=this.arr[i].Min();
            if(min>k)
                min=k;
        }
        return min;
    }
    public int minPos(){
        if(this.size==0)
            return 0;
        int minP=this.arr[0].minPos();
        for (int i=1;i<this.size;i++){
            int k=this.arr[i].minPos();
            if(minP>k)
                minP=k;
        }
        return minP;
    }
    public int maxNeg(){
        if(this.size==0)
            return 0;
        int maxN=this.arr[0].maxNeg();
        for (int i=1;i<this.size;i++){
            int k=this.arr[i].maxNeg();
            if(maxN<k)
                maxN=k;
        }
        return maxN;
    }
    public int findMaxSumRow(){
        int s=this.arr[0].Sum();
        int p=0;
        for (int i=1;i<this.size;i++){
            int k= arr[i].Sum();
            if(s<k){
                s=k;
                p=i;
            }
        }
        return p;
    }
    public void addHead(MangMotChieu a){
        MangMotChieu[] t= new MangMotChieu[this.size+1];
        t[0]=a;
        for (int i=0;i<this.size;i++){
            t[i+1]=arr[i];
        }
        this.arr=t;
        this.size++;
    }
    public void addTail(MangMotChieu a){
        MangMotChieu[] t=new MangMotChieu[this.size+1];
        for (int i=0;i<this.size;i++){
            t[i]=arr[i];
        }
        t[this.size]=a;
        this.arr=t;
        this.size++;
    }
    public void add(int k, MangMotChieu val){
        if(k<0||k>=this.size)
            return;
        MangMotChieu[] t=new MangMotChieu[this.size+1];
        for (int i=0;i<k;i++){
            t[i]=this.arr[i];
        }
        t[k]=val;
        for (int i=k;i<this.size;i++){
            t[i+k]=this.arr[i];
        }
        this.arr=t;
        this.size++;
    }
    public void delete(int k){
        MangMotChieu[] t=new MangMotChieu[this.size-1];
        for(int i=0;i<k;i++){
            t[i]=this.arr[i];
        }
        for(int i=k+1;i<this.size;i++){
            t[i-1]=this.arr[i];
        }
        this.arr=t;
        this.size--;
    }
    public static MangRangCua parseMangRangCua(String a){
        String[] x=a.split(", ");
        MangRangCua t=new MangRangCua();
        for (String i:x){
            String[]y=i.split(" ");
            MangMotChieu r=new MangMotChieu();
            for(String j:y){
                r.addTail(Integer.parseInt(j));
            }
            t.addTail(r);
        }
        return t;
    }
    public void copy(MangRangCua a){
        this.arr=a.arr;
        this.size=a.size;
    }
}
