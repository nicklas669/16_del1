import java.util.Scanner;

import boundary.Menu;
import data.IUserData;
import data.UserData;
import functionality.ILoginFunktion;
import functionality.IPasswordFunktion;
import functionality.IUserFunktion;
import functionality.LoginFunktion;
import functionality.PasswordFunktion;
import functionality.UserFunktion;
import javafx.scene.chart.PieChart.Data;

public class Main {
	
	public static void main(String[] args) {
		IUserData data = new UserData();
		ILoginFunktion login = new LoginFunktion(data);
		IPasswordFunktion pass = new PasswordFunktion();
		IUserFunktion user = new UserFunktion(data);
		Menu menu = new Menu(login, pass, user);
	}
}
