import java.util.Scanner;

import javafx.scene.chart.PieChart.Data;

public class Main {
	static Scanner scan;
	static UserData data;
	
	public static void main(String[] args) {
		int activeUser, choice;
		boolean adminMode = false;
		data = new UserData();
		LoginFunktion lf = new LoginFunktion(data);
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
			else Menu_changePw(ID);
			break;
		case 2:
			if (adminMode) Menu_changePw(ID);
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
				if (adminMode) Menu_opretOpr();
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

	private static void Menu_opretOpr() {
		System.out.println("Opret operatør");
		System.out.println("Indtast ID på ny operatør:");
		// TJEK HER OM INDTASTET ID ER GYLDIGT (IKKE BRUGT I FORVEJEN)
		System.out.println("Indtast navn på ny operatør:");
		System.out.println("Indtast CPR på ny operatør:");
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

	private static void Menu_changePw(int ID) {
		System.out.println("Indtast dit nuværende password:");
		System.out.println("Indtast dit nye password:");
		// TJEK HER OM INDTASTET PASSWORD ER GYLDIGT
		System.out.println("Indtast dit nye password igen:");
		// TJEK HER OM INDTASTET PASSWORD ER DET SAMME SOM FORRIGE INDTASTNING
	}
	
	private static void Menu_weight() {

	}

}
