package functionality;
import java.util.Scanner;

import data.IUserData;
import data.UserData;


public class LoginFunktion implements ILoginFunktion {
	int id;
	String pw;
	IUserData data;
	
	public LoginFunktion(IUserData data) {
		this.data = data;
	}

	public int login() {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		while (run) {
			System.out.println("Indtast ID: "); // evt. tjekke om ID er gyldigt
			id = scan.nextInt(); // input handling
			System.out.println("Indtast password: ");
			pw = scan.next();
			for (UserData.Operatoer opr:data.getOperatoerArray()) {
				if (id == opr.getID() && opr.getPw().equals(pw)) run=false;
			}
		}
		return id;
	}
	
	public int login(int id) { // used for testing purposes
		return id;
	}
	
}
