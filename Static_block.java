import java.util.*;

public class Static_block {

    static {
        Scanner sc = new Scanner(System.in);
        static int B = sc.nextInt();
        static int H = sc.nextInt();
        static int flag = 0;
        if(B<0 ||H<0){
            flag = 0;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        else{
            flag = 1;
        }

    }

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

