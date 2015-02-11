import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		
		int id;
		String pw;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Velkommen til lort! Du skal logge ind for at komme videre.");
		System.out.println("Indtast ID: "); // evt. tjekke om ID er gyldigt
		id = scan.nextInt();
		System.out.println("Indtast password: ");
		pw = scan.next();
		
	}

}
