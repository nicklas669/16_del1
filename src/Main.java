import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int activeUser, choice;
		boolean adminMode = false;
		UserData data = new UserData();
		LoginFunktion lf = new LoginFunktion(data);
		activeUser = lf.login();
		Scanner scan = new Scanner(System.in);

		if (activeUser == 10) {
			System.out.println("Du er logget ind som system administrator.");
			adminMode = true;
		} else { 
			System.out.println("Du er logget ind som operatør."); 
		}

		if (!adminMode) {
			System.out.println("1 - Ændre password");
			System.out.println("2 - Vægt");
			System.out.println("3 - Afslut applikation");
			switch (scan.nextInt()) {
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		}
		else {
			System.out.println("1 - Operatør administration");
			System.out.println("2 - Ændre password");
			System.out.println("3 - Vægt");
			System.out.println("4 - Afslut applikation");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("Operatør administration");
				System.out.println("1 - Vis operatører");
				System.out.println("2 - Opret operatør");
				System.out.println("3 - Slet operatører");
				System.out.println("4 - Tilbage");
				switch (scan.nextInt()) {
				case 1:
					for (UserData.Operatoer opr:data.getOperatoerArray()) {
						System.out.println(opr);
					}
					break;
				case 2:
					break;
				case 3:
					break;
				}
				break;
			case 2:
				
			default:
				break;
			}
		}
		
		//		PasswordFunktion pf = new PasswordFunktion();
	}

}
