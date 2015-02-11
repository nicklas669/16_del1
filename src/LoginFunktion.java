import java.util.Scanner;


public class LoginFunktion {
	int id;
	String pw;
	UserData data;
	
	public LoginFunktion(UserData data) {
		this.data = data;
	}

	public int login() {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Velkommen til lort! Du skal logge ind for at komme videre.");
		
		while (run) {
			System.out.println("Indtast ID: "); // evt. tjekke om ID er gyldigt
			id = scan.nextInt();
			System.out.println("Indtast password: ");
			pw = scan.next();
			for (UserData.Operatoer opr:data.getOperatoerArray()) {
				if (id == opr.getID() && opr.getPw().equals(pw)) run=false;
			}
		}
		return id;
	}
}
