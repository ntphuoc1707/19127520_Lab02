package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap2;
import vn.edu.hcmus.student.sv19127520.Lab02.BaiTap1.*;

import java.util.*;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER -19127520
 * Date 23/10/2021 - 3:55 CH
 * Description: ...
 */
public class MangHaiChieu {
    private int[][] arr;
    private int col;
    private int row;

    /**
     * Initiate
     */
    public MangHaiChieu(){
        this.arr=null;
        this.row=0;
        this.col=0;
    }
    /*
    Get method
     */
    public int[][] get()
    {
        return this.arr;
    }

    /**
     * Set method
     * @param a
     */
    public void set(int[][] a)
    {
        int[][] t=new int[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                t[i][j]=a[i][j];
            }
        }
        this.arr=t;
    }

    /**
     * Input method
     */
    public void Input(){
        int c,r;
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Row: ");
        r=scan.nextInt();
        if(r<0)
        {
            System.out.print("Size is invalid");
            return;
        }
        System.out.print("Enter Column: ");
        c=scan.nextInt();
        if(c<0)
        {
            System.out.print("Size is invalid");
            return;
        }
        int[][] t=new int[r][c];
        for(int i=0;i<r; i++)
        {
            for (int j=0;j<c;j++){
                System.out.print(String.format("Element at [%d][%d] = ",i,j));
                t[i][j]=scan.nextInt();
            }

        }
        this.arr=t;
        this.col=c;
        this.row=r;
    }
    /*
    Display MangHaiChieu
     */
    public void Print(){
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Sort Ascending on each row
     */
    public void sortRowAscend(){
        for(int i=0;i<row;i++){
            MangMotChieu t=new MangMotChieu(arr[i]);
            t.sortAscend();
            arr[i]=t.get();
        }
    }

    /**
     * Sort Descending on each column
     */
    public void sortColDescend(){
        for (int i=0;i<row;i++){
            MangMotChieu t=new MangMotChieu();
            for (int j=0;j<col;j++){
                t.addTail(arr[j][i]);
            }
            t.sortDescend();
            int[] s=t.get();
            for (int j=0;j<col;j++){
                arr[j][i]=s[j];
            }
        }
    }

    /**
     * Sum elements
     * @return Sum
     */
    public int Sum(){
        int s=0;
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
               s+=arr[i][j];
        return s;
    }

    /**
     * Product elements
     * @return product
     */
    public int Product(){
        int s=1;
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                s*=arr[i][j];
        return s;
    }

    /**
     * Find max value
     * @return max value
     */
    public int Max(){
        int max=arr[0][0];
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                if(arr[i][j]>max)
                    max=arr[i][j];
        return max;
    }

    /**
     * Find min value
     * @return min value
     */
    public int Min(){
        int min=arr[0][0];
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                if(arr[i][j]<min)
                    min=arr[i][j];
        return min;
    }

    /**
     * Find minimum positive number
     * @return minimum positive number
     */
    public int minPos(){
        if(arr==null){
            return 0;
        }
        int minP=Max();
        for (int[] i:arr){
            MangMotChieu t=new MangMotChieu(i);
            int k=t.minPos();
            if(minP<k)
                minP=k;
        }
        if(minP<=0){
            return 0;
        }
        return minP;
    }

    /**
     * Find maximum negative number
     * @return maximum negative number
     */
    public int maxNeg(){
        if(arr==null){
            return 1;
        }
        int maxN=Min();
        for(int[] i:arr){
            MangMotChieu t=new MangMotChieu(i);
            int k=t.maxNeg();
            if(maxN>k)
                maxN=k;
        }
        if(maxN>0)
            return 0;
        return maxN;
    }

    /**
     * Find row that have maximum sum
     * @return index row
     */
    public int findMaxSumRow(){
        int max=new MangMotChieu(arr[0]).Sum();
        int p=0;
        for (int i=1;i<row;i++){
            MangMotChieu t=new MangMotChieu(arr[i]);
            int k=t.Sum();
            if(k>max) {
                max = k;
                p=i;
            }
        }
        return p;
    }

    /**
     * Sum of a column
     * @param col
     * @return sum
     */
    public int SumCol(int col){
        int s=0;
        for(int i=0;i<row;i++){
            s+=arr[col][i];
        }
        return s;
    }

    /**
     * Find column that have maximum sum
     * @return index column
     */
    public int findMaxSumCol(){
        int max=SumCol(0);
        int p=0;
        for(int i=1;i<col;i++){
            int k=SumCol(i);
            if(k>max){
                k=max;
                p=i;
            }
        }
        return p;
    }

    /**
     * Insert a row to head
     * @param a
     */
    public void addHeadRow(int[] a){
        if(a.length!=this.col){
            System.out.print("Invalid");
            return;
        }
        int[][] t=new int[row+1][col];
        t[0]=a;
        for(int i=0;i<row;i++){
            t[i+1]=arr[i];
        }
        this.arr=t;
        row++;
    }

    /**
     * Insert a row to tail
     * @param a
     */
    public void addTailRow(int[] a){
        if(a.length!=this.col && this.col!=0){
            System.out.print("Invalid");
            return;
        }
        int[][] t=new int[row+1][a.length];
        for(int i=0;i<row;i++){
            t[i]=arr[i];
        }
        t[row]=a;
        this.arr=t;
        col=a.length;
        row++;
    }

    /**
     * Insert a row to k position
     * @param a
     * @param k
     */
    public void addRowAt(int[] a, int k){
        if(a.length!=this.col){
            System.out.print("Invalid");
            return;
        }
        int[][] t=new int[row+1][col];
        int p=k;
        for(int i=0;i<k;i++){
            t[i]=arr[i];
        }
        t[k]=a;
        for(int i=k;i<row;i++){
            p++;
            t[p]=arr[i];
        }
        this.arr=t;
        row++;
    }

    /**
     * Delete a row
     * @param k
     */
    public void deleteRow(int k){
        if(k<0 || k>=row){
            return;
        }
        int[][] t=new int[row-1][col];
        for (int i=0;i<k;i++){
            t[i]=arr[i];
        }
        int p=k;
        for (int i=k+1;i<row;i++){
            t[p]=arr[i];
            p++;

        }
        this.arr=t;
        row--;
    }

    /**
     * Delete a column
     * @param k
     */
    public void deleteCol(int k){
        if(k<0||k>=col){
            return;
        }
        int[][] t= new int[row][col-1];
        for(int i=0;i<row;i++){
            MangMotChieu p=new MangMotChieu(arr[i]);
            p.delete(k);
            t[i]=p.get();
        }
        this.arr=t;
        col--;
    }

    /**
     * Parse string to MangHaiChieu
     * @param a
     * @return MangHaiChieu
     */
    public static MangHaiChieu parseMangHaiChieu(String a){
        String[] x=a.split(", ");
        MangHaiChieu t=new MangHaiChieu();
        for (String i:x){
            String[]y=i.split(" ");
            MangMotChieu r=new MangMotChieu();
            for(String j:y){
                r.addTail(Integer.parseInt(j));
            }
            t.addTailRow(r.get());
        }
        return t;
    }

    /**
     * Copy
     * @param a
     */
    public void copy(MangHaiChieu a){
        this.arr=a.arr;
        this.col=a.col;
        this.row=a.row;
    }
}
