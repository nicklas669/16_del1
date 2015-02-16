import java.util.Scanner;

import javafx.scene.chart.PieChart.Data;

public class Main {
	static Scanner scan;
	static UserData data;
	static PasswordFunktion pf;
	
	public static void main(String[] args) {
		int activeUser;
		boolean adminMode = false;
		data = new UserData();
		LoginFunktion lf = new LoginFunktion(data);
		pf = new PasswordFunktion();
		activeUser = lf.login(10);
		scan = new Scanner(System.in);

		if (activeUser == 10) {
			System.out.println("Du er logget ind som system administrator.");
			adminMode = true;
		} else { 
			System.out.println("Du er logget ind som operatør."); 
		}
		Menu_main(adminMode, activeUser);
	}
	
	public static void Menu_main(boolean adminMode, int ID) {
		if (adminMode) {
			System.out.println("1) Operatør Administration\n"
					+ "2) Ændre password\n"
					+ "3) Vægt\n"
					+ "4) Afslut applikation");
		}
		else {
			System.out.println("1) Ændre password\n"
					+ "2) Vægt\n"
					+ "3) Afslut applikation");
		}
		switch(scan.nextInt()) {
		case 1:
			if (adminMode) Menu_oprAdmin(adminMode, ID);
			else Menu_changePw(adminMode, ID);
			break;
		case 2:
			if (adminMode) Menu_changePw(adminMode, ID);
			else Menu_weight();
			break;
		case 3:
			if (adminMode) Menu_weight();
			else System.exit(1);
			break;
		case 4:
			if (adminMode) System.exit(1);
			break;
		}
	}
	

	private static void Menu_oprAdmin(boolean adminMode, int ID) {
		if (adminMode) {
			System.out.println("Operatør Administration\n"
					+ "1) Vis operatører\n"
					+ "2) Opret operatør\n"
					+ "3) Slet operatør\n"
					+ "4) Tilbage til hovedmenu");
			switch(scan.nextInt()) {
			case 1:
				if (adminMode) Menu_visOpr(adminMode, ID);
				break;
			case 2:
				if (adminMode) Menu_opretOpr(adminMode, ID);
				break;
			case 3:
				if (adminMode) Menu_sletOpr();
				break;
			case 4:
				if (adminMode) Menu_main(adminMode, ID);
				break;
			}
		} else {
			System.out.println("Du har ikke adgang til operatør administration!");
		}
	}
	
	private static void Menu_sletOpr() {
		
	}

	private static void Menu_opretOpr(boolean adminMode, int ID) {
		System.out.println("Opret operatør");
		System.out.println("Indtast ID på ny operatør:");
		boolean idExists = false;
		int newID;
		while (true) {
			idExists = false;
			newID = scan.nextInt();
			for (UserData.Operatoer opr:data.getOperatoerArray()) {
				if (opr.getID() == newID) {
					idExists = true;
				}
			}
			if (!idExists) {
				break;
			} else {
				System.out.println("ID findes allerede, prøv igen:");
			}
		}
		scan.nextLine();
		System.out.println("Indtast navn på ny operatør:");
		String name = scan.nextLine();
		System.out.println("Indtast CPR på ny operatør:");
		String cpr = scan.nextLine();
		data.addOperator(newID, name, cpr);
		System.out.println("Operatør oprettet!");
		Menu_oprAdmin(adminMode, ID);
	}

	private static void Menu_visOpr(boolean adminMode, int ID) {
		System.out.println("Vis operatører");
		// PRINT OPERATØRER HER
		for (UserData.Operatoer opr:data.getOperatoerArray()) System.out.println(opr);
		System.out.println("1) Tilbage til Operatør Administration");
		if (scan.nextInt() == 1) {
			Menu_oprAdmin(adminMode, ID);
		}
	}

	private static void Menu_changePw(boolean adminMode, int ID) {
		UserData.Operatoer opr2 = null;
		scan.nextLine();
		System.out.println("Indtast dit nuværende password:");
		String currentPw = scan.nextLine();
		for (UserData.Operatoer opr:data.getOperatoerArray()) {
			if (opr.getID() == ID) {
				opr2 = opr;
				while (!opr.getPw().equals(currentPw)) {
					System.out.println("Forkert password, prøv venligst igen:");
					currentPw = scan.nextLine();
				}
			}
		}
		System.out.println("Indtast dit nye password (skal overholde DTU's regler for password):");
		String newPw1 = scan.nextLine();
		while (!pf.validatePw(newPw1)) {
			System.out.println("Det indtastede overholder ikke DTU's regler for password! Prøv igen:");
			newPw1 = scan.nextLine();
		}
		System.out.println("Indtast dit nye password igen:");
		String newPw2 = scan.nextLine();
		while (!newPw2.equals(newPw1)) {
			System.out.println("Det to password stemmer ikke overens! Prøv igen:");
			newPw2 = scan.nextLine();
		}
		opr2.setPw(newPw1);
		System.out.println("Dit password er skiftet!");
		Menu_main(adminMode, ID);
	}
	
	private static void Menu_weight() {

	}

}
