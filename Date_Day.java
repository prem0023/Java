import java.time.LocalDate; 
import java.util.Scanner;
  
public class Date_Day { 
  
	public static String findDay(int month, int day, int year) {
        return LocalDate.of(year,month,day).getDayOfWeek().name();

    }
    public static void main(String[] args) 
    { 
    	Scanner sc = new Scanner(System.in);
        int year = sc.nextInt(); 
        int months = sc.nextInt(); 
        int days = sc.nextInt();
  
        System.out.println(findDay(months, days,year)); 
    } 
} 