package vn.edu.hcmus.student.sv19127520.Lab02.BaiTap1;

import java.util.Scanner;

/**
 * vn.edu.hcmus.student.sv19127520.Lab02
 * Created by USER-19127520
 * Date 23/10/2021 - 10:53 SA
 * Description: ...
 */
public class MangMotChieu {
    private int[] arr;
    private int size;

    /**
     * Initiate no parameter
     */
    public MangMotChieu()
    {
        this.arr=null;
        this.size=0;
    }

    /**
     * Initiate with parameter
     * @param arr
     */
    public MangMotChieu(int... arr)
    {
        this.arr=arr;
        this.size=arr.length;
    }

    /**
     * Get MangMotChieu
     * @return MangMotChieu
     */
    public int[] get()
    {
        return arr;
    }

    public void set(int[] a)
    {
        this.arr=a;
        this.size=a.length;
    }

    /**
     * Input method
     */
    public void Input(){
        int s;
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter size: ");
        s=scan.nextInt();
        if(s<0)
        {
            System.out.print("Size is invalid");
            return;
        }
        int[] t=new int[s];
        for(int i=0;i<s; i++)
        {
            System.out.print(String.format("Element at %d = ",i));
            t[i]=scan.nextInt();
        }
        this.arr=t;
        this.size=s;
    }

    public void Print()
    {
        for(int i=0;i<this.size;i++)
        {
            System.out.print(this.arr[i]+" ");
        }
    }

    /**
     * Sort Ascending
     */
    public void sortAscend()
    {
        for(int i=0;i<this.size-1;i++)
        {
            for(int j=i+1;j<this.size;j++){
                if(this.arr[j]<this.arr[i])
                {
                    int t=this.arr[i];
                    this.arr[i]=this.arr[j];
                    this.arr[j]=t;
                }
            }
        }
    }

    /**
     * Sort descending
     */
    public void sortDescend()
    {
        for(int i=0;i<this.size-1;i++)
        {
            for(int j=i+1;j<this.size;j++){
                if(this.arr[j]>this.arr[i])
                {
                    int t=this.arr[i];
                    this.arr[i]=this.arr[j];
                    this.arr[j]=t;
                }
            }
        }
    }

    /**
     * Sum method
     * @return Sum
     */
    public int Sum(){
        int s=0;
        for (int i=0;i<this.size;i++)
        {
            s+=this.arr[i];
        }
        return s;
    }

    /**
     * Product method
     * @return product
     */
    public int Product()
    {
        if(this.size==0)
            return 0;
        int p=1;
        for (int i=0;i<this.size;i++)
        {
            p*=this.arr[i];
        }
        return p;
    }

    /**
     * Find biggest value
     * @return biggest value
     */
    public int Max()
    {
        if(this.size<=0)
            return 0;
        int max=this.arr[0];
        for (int i=1;i<this.size;i++)
        {
            if(max<this.arr[i]){
                max=this.arr[i];
            }
        }
        return max;
    }

    /**
     * Find minimum value
     * @return minimum value
     */
    public int Min()
    {
        if(this.size<=0)
            return 0;
        int min=this.arr[0];
        for (int i=1;i<this.size;i++)
        {
            if(min>this.arr[i]){
                min=this.arr[i];
            }
        }
        return min;
    }

    /**
     * Find minimum positive number
     * @return minimum positive number
     */
    public int minPos()
    {
        if(this.size<=0)
            return 0;
        int minP=Max();
        for(int i=0;i<this.size;i++)
        {
            if(this.arr[i]>0){
                if(minP>this.arr[i])
                    minP=this.arr[i];
            }
        }
        return minP;
    }

    /**
     * Find maximum negative number
     * @return maximum negative number
     */
    public int maxNeg()
    {
        if(this.size<=0)
            return 0;
        int maxN=Min();
        for (int i=0;i<this.size;i++)
        {
            if(this.arr[i]<0)
            {
                if(maxN<this.arr[i])
                    maxN=this.arr[i];
            }
        }
        if(maxN>0){
            return 0;
        }
        return maxN;
    }

    /**
     * Insert a number to head of array
     * @param val
     */
    public void addHead(int val)
    {
        int[] t=new int[this.size+1];
        t[0]=val;
        for (int i=1;i<this.size;i++)
            t[i]=this.arr[i-1];
        this.arr=t;
        this.size++;
    }

    /**
     * Insert a number to tail of array
     * @param val
     */
    public void addTail(int val)
    {
        int[] t=new int[this.size+1];
        for (int i=0;i<this.size;i++)
            t[i]=this.arr[i];
        t[this.size]=val;
        this.arr=t;
        this.size++;
    }

    /**
     * Insert a value at position
     * @param pos
     * @param val
     */
    public void add(int pos, int val) {
        if (pos >= 0 || pos < this.size) {
            int[] t = new int[this.size + 1];
            for (int i = 0; i < pos; i++)
                t[i] = this.arr[i];
            t[pos] = val;
            for (int i = pos + 1; i < this.size + 1; i++)
                t[i] = this.arr[i-1];
            this.arr = t;
            this.size++;
        }
    }

    /**
     * Delete position
     * @param pos
     */
    public void delete(int pos) {
        if (pos >= 0 || pos < this.size) {
            int[] t = new int[this.size - 1];
            for (int i = 0; i < pos; i++)
                t[i] = this.arr[i];
            for (int i = pos + 1; i < this.size; i++)
                t[i - 1] = this.arr[i];
            this.arr = t;
            this.size--;
        }
    }

    /**
     * Delete elements that have value=val
     * @param val
     */
    public void deleteVal(int val)
    {
        int count=0;
        for (int i=0;i<this.size;i++) {
            if (this.arr[i] == val) count++;
        }
        int[] t=new int[this.size-count];
        int k=0;
        for (int i=0;i<this.size;i++)
        {
            if(this.arr[i]!=val){
                t[k]=this.arr[i];
                k++;
            }

        }
        this.arr=t;
        this.size=this.size-count;
    }

    /**
     * Update value at pos
     * @param pos
     * @param val
     */
    public void updateAt(int pos, int val){
        if(pos>=0 && pos<this.size)
        {
            this.arr[pos]=val;
        }
    }

    /**
     * Update Value
     * @param oldVal
     * @param newVal
     */
    public void updateVal(int oldVal, int newVal)
    {
        for (int i=0;i<this.size;i++)
            if(this.arr[i]==oldVal)
                this.arr[i]=newVal;
    }

    /**
     * Parse string to MangMotChieu
     * @param a
     * @return MangMotChieu
     */
    public static MangMotChieu parseMangSoNguyen(String a) {
        try {
            MangMotChieu t = new MangMotChieu();
            String[] s = a.split(" ");
            for (String i : s) {
                t.addTail(Integer.parseInt(i));
            }
            return t;
        }
        catch (NumberFormatException ex){
            System.out.print("INVALID");
        }
        return null;
    }

    /**
     * Merge two MangMotChieu
     * @param a
     */
    public static MangMotChieu Merge(MangMotChieu...a){
        int s=0;
        for (MangMotChieu i:a) {
            s=s+i.size;
        }
        int[] t=new int[s];
        int k=0;
        for(MangMotChieu i:a){
            for(int j=0;j<i.size;j++){
                t[k]=i.arr[j];
                k++;
            }
        }
        return new MangMotChieu(t);
    }

    /**
     * Copy MangMotChieu
     * @param a
     */
    public static MangMotChieu copy(MangMotChieu a){
        return a;
    }

    /**
     * Reset array to a value
     * @param val
     */
    public void reset(int val){
        for(int i=0;i<this.size;i++){
            this.arr[i]=val;
        }
    }
}
