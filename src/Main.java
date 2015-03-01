import boundary.Menu;
import data.IUserData;
import data.IUserData.DALException;
import data.UserData;
import functionality.ILoginFunktion;
import functionality.IPasswordFunktion;
import functionality.IUserFunktion;
import functionality.LoginFunktion;
import functionality.PasswordFunktion;
import functionality.UserFunktion;

public class Main {
	
	public static void main(String[] args) throws DALException {
		IUserData data = new UserData();
		ILoginFunktion loginf = new LoginFunktion(data);
		IPasswordFunktion passf = new PasswordFunktion();
		IUserFunktion userf = new UserFunktion(data);
		Menu menu = new Menu(loginf, passf, userf);
	}
}
