import java.util.Scanner;

public class ProducerConsumer {
	
	static int s=1;    //Entry barrier in critical section
	static int e=5;	//number of empty cell
	static int f=0;	//no. of slots are full
	
	static int wait(int sf) {
		if(sf>=0) {
			sf--;
		}
		return sf;
	}
	static int signal(int sf) {
		sf++;
		return sf;
	}
	static void Producer() {
		e = wait(e);
		s = wait(s);
		s = signal(s);
		f = signal(f);
		System.out.println("Product is Produced");
		System.out.println("Empty Cell: "+e+", No. of slot full: "+f);
		System.out.println("Make other Choice..");
		Input_();
		
	}
	static void Consumer() {
		f = wait(f);
		s = wait(s);
		s = signal(s);
		e = signal(e);
		System.out.println("You Consumed Product");
		System.out.println("Empty Cell: "+e+", No. of slot full: "+f);
		System.out.println("Make other Choice..");
		Input_();
		
	}
	static void Input_() {
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("Enter your choice:");
			System.out.println("1. to produce something");
			System.out.println("2. to consume something");
			System.out.println("3. to exit");
		
			int choice = sc.nextInt();
			switch(choice) {
			case 1:	
				if((s==1)&&(e!=0))
					Producer();
				else
					System.out.println("Cell is full!!");
				break;
			case 2:	
				if((s==1)&&(f!=0))
					Consumer();
				else
					System.out.println("Cell is empty!!");
				break;
			case 3:
				flag = false;
				System.exit(0);
			}
		}
		sc.close();
	}

	public static void main(String[] args) {
		
		System.out.println("Capacity to store Product is 5");
		
		Input_();
		
	}

}
