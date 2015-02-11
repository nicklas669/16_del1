import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		UserData data = new UserData();
		PasswordFunktion pf = new PasswordFunktion();
		LoginFunktion lf = new LoginFunktion(data);
	}

}
