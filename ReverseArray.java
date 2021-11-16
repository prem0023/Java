import java.util.*;

class ReverseArray
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//List<Integer> list = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
		
		Collections.reverse(list);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+ " ");
		}
		
		sc.close();
	}
}