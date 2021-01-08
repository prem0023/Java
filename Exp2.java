import java.util.*;
import java.io.*;

public class Exp2{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int s[]= new int[16];
        int a[]= new int[3];
        int b[]= new int[3];
        int n[]= new int[3];
        for(int i=0;i<3;i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            n[i] = sc.nextInt();
        }
        int sum=0;
        for(int k=0;k<3;k++) {
        	for(int i=0;i<n[k];i++){
                for(int j=0;j<=i;j++){
                    sum = (int) (sum + b[k]*(Math.pow(2,j)));
                }
                s[i]=a[k]+sum;
                sum=0;
            }
            for(int i=0;i<n[k];i++){
                System.out.print(s[i]+" ");
            }
            System.out.println();
        }
        
    }
}

