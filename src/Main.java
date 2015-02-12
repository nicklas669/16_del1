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
			System.out.println("Du er logget ind som operat�r."); 
		}
		Menu_main(adminMode, activeUser);
	}
	
	public static void Menu_main(boolean adminMode, int ID) {
		if (adminMode) {
			System.out.println("1) Operat�r Administration\n"
					+ "2) �ndre password\n"
					+ "3) V�gt\n"
					+ "4) Afslut applikation");
		}
		else {
			System.out.println("1) �ndre password\n"
					+ "2) V�gt\n"
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
			System.out.println("Operat�r Administration\n"
					+ "1) Vis operat�rer\n"
					+ "2) Opret operat�r\n"
					+ "3) Slet operat�r\n"
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
			System.out.println("Du har ikke adgang til operat�r administration!");
		}
	}
	
	private static void Menu_sletOpr() {
		
	}

	private static void Menu_opretOpr() {
		System.out.println("Opret operat�r");
		System.out.println("Indtast ID p� ny operat�r:");
		// TJEK HER OM INDTASTET ID ER GYLDIGT (IKKE BRUGT I FORVEJEN)
		System.out.println("Indtast navn p� ny operat�r:");
		System.out.println("Indtast CPR p� ny operat�r:");
	}

	private static void Menu_visOpr(boolean adminMode, int ID) {
		System.out.println("Vis operat�rer");
		// PRINT OPERAT�RER HER
		for (UserData.Operatoer opr:data.getOperatoerArray()) System.out.println(opr);
		System.out.println("1) Tilbage til Operat�r Administration");
		if (scan.nextInt() == 1) {
			Menu_oprAdmin(adminMode, ID);
		}
	}

	private static void Menu_changePw(int ID) {
		System.out.println("Indtast dit nuv�rende password:");
		System.out.println("Indtast dit nye password:");
		// TJEK HER OM INDTASTET PASSWORD ER GYLDIGT
		System.out.println("Indtast dit nye password igen:");
		// TJEK HER OM INDTASTET PASSWORD ER DET SAMME SOM FORRIGE INDTASTNING
	}
	
	private static void Menu_weight() {

	}

}
