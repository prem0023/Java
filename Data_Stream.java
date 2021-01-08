import java.io.*;

public class Data_Stream {

	public static void main(String[] args) throws IOException
	{
		DataInputStream dis = new DataInputStream(System.in);
		System.out.println("Enter the name: ");
		String name = dis.readLine();
		System.out.println("Enter roll: ");
		int roll = Integer.parseInt(dis.readLine());
		System.out.println("Enter fee: ");
		double fee = Double.parseDouble(dis.readLine());
		System.out.println("Name: "+name+"  Roll: "+roll+ " fee: "+fee);
	}

}
