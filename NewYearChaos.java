import java.io.DataInputStream;
import java.io.IOException;


public class NewYearChaos {

    // Complete the minimumBribes function below.
    static int minimumBribes(int[] q) {
        int c=0;
        int y = 0;
        int[] a = new int[q.length];
        for(int i=1;i<=q.length;i++){
            a[i-1] = i;
        }
        for(int i=1;i<=q.length;i++){
            try{
                if(i==q[i-1]){
                	y++;
                }    
            }
            catch(Exception e){
            }
            try{
                if(i==q[i-2]){
                	y++;
                }    
            }
            catch(Exception e){
            }
            try{
                if(i==q[i-3]){
                	y++;
                }    
            }
            catch(Exception e){
            }
            try{
                if(i==q[i]){
                	y++;
                }    
            }
            catch(Exception e){
            }
            try{
                if(i==q[i+1]){
                	y++;
                }    
            }
            catch(Exception e){
            }
        }
        if(y>0) {
        	for(int i=1;i<=q.length;i++){
                if(q[i-1]== a[i-1]){
                }
                else if(q[i-1] == a[i]){
                    int x = a[i-1];
                    a[i-1] = a[i];
                    a[i] = x;
                    c++;
                }
                else if(q[i-1] == a[i+1]){
                    int x = a[i+1];
                    a[i+1] = a[i];
                    a[i] = a[i-1];
                    a[i-1] = x;
                    c++;
                    c++;
                }
                else{
                    System.out.println("Too chaotic");
                    return 0;
                }
            }
        	
        }
        else{
            System.out.println("Too chaotic");
            return 0;  
        }
        //i==q[i-1] || i==q[i-2] || i==q[i-3] || i==q[i] || i==q[i+1]
        
        return c;

    }

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException{
        DataInputStream dis = new DataInputStream(System.in);
        int t = Integer.parseInt(dis.readLine());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(dis.readLine());
            int[] q = new int[n];

            String[] qItems = dis.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            int x = minimumBribes(q);
            if(x >0) {
                System.out.println(x);
            }
        }

    }
}
