
public class Asciii {

	public static void main(String[] args) {
		/*
		String d = "f";
        Character c = 'b';
        int value = c;
        //1 : Assigning
        System.out.println("Ascii : "+value);
        //2 : Typecasting
        System.out.println("Ascii : "+(int)c);
        
        //System.out.println(a.compareTo(b));
        //System.out.println(b.toUpperCase());
        //System.out.println(b.toLowerCase());
        //System.out.println((int)b.charAt(0));
        */
		
		String str = "premkumar";
        String a = str.substring(0,4)+str.substring(4,6).toUpperCase() + str.substring(6);
        System.out.println(a);
        
	}

}
