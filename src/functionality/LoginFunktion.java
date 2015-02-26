package functionality;
import java.util.Scanner;

import data.IUserData;
import data.IUserData.DALException;
import data.UserData;


public class LoginFunktion implements ILoginFunktion {
	int id;
	String pw;
	IUserData data;
	
	public LoginFunktion(IUserData data) {
		this.data = data;
	}

	public int login() throws DALException {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		while (run) {
			System.out.println("Indtast ID: ");
			id = scan.nextInt();
			scan.nextLine();
			System.out.println("Indtast password: ");
			pw = scan.nextLine().trim();
			if (data.getOperatoer(id).getPw().equals(pw)) return id;
			else throw new DALException();
		}
		return id;
	}
	
	public int login(int id) { // used for testing purposes
		return id;
	}
	
}
