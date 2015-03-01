package boundary;
import java.util.Scanner;

import data.IUserData.DALException;
import functionality.ILoginFunktion;
import functionality.IPasswordFunktion;
import functionality.IUserFunktion;


public class Menu {
	Scanner scan;
	ILoginFunktion lf;
	IPasswordFunktion passf;
	IUserFunktion userf;
	int ID;
	boolean adminMode = false;
	boolean looping = false;
	
	public Menu(ILoginFunktion login, IPasswordFunktion pass, IUserFunktion user) {
		this.scan = new Scanner(System.in);
		this.lf = login;
		this.passf = pass;
		this.userf = user;
		
		System.out.println("Velkommen til vægt med operatørsystem.\n"
				+ "Du skal logge ind for at komme videre.");
		while (true) {
			try {
				ID = lf.login();
				break;
			} catch (DALException e) {
				System.out.println("ID findes ikke eller password er forkert, prøv igen.");
			}
		}
		if (ID == 10) {
			System.out.println("Du er logget ind som system administrator.");
			adminMode = true;
		} else { 
			System.out.println("Du er logget ind som operatør."); 
		}
		Menu_main(adminMode, ID);
	}
	
	public void Menu_main(boolean adminMode, int ID) {
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
			else Menu_weight(adminMode, ID);
			break;
		case 3:
			if (adminMode) Menu_weight(adminMode, ID);
			else System.exit(1);
			break;
		case 4:
			if (adminMode) System.exit(1);
			break;
		}
	}


	public void Menu_oprAdmin(boolean adminMode, int ID) {
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
				if (adminMode) Menu_sletOpr(adminMode, ID);
				break;
			case 4:
				if (adminMode) Menu_main(adminMode, ID);
				break;
			}
		} else {
			System.out.println("Du har ikke adgang til operatør administration!");
			Menu_main(adminMode, ID);
		}
	}

	public void Menu_sletOpr(boolean adminMode, int ID) {
		System.out.println("Slet operatør");
		System.out.print("Indtast ID på operatør der skal slettes:");
		int checkID = 0;
		looping = true;
		do {
			try {
				checkID = scan.nextInt();
				userf.checkExists(checkID);
				looping = false;
				System.out.println("Er du sikker på at du vil slette operatør "+userf.getNameById(checkID)+" med ID: "+checkID+"?");
				System.out.println("(indtast \"JA\" hvis du er sikker");
				scan.nextLine();
				String input = scan.nextLine();
				if (input.toUpperCase().trim().equals("JA")) {
					userf.removeOperator(checkID);
					System.out.println("Operator med ID " + checkID+ " er slettet.");
				} 
				Menu_oprAdmin(adminMode, ID);
			} catch (DALException e) {
				System.out.print("ID findes ikke, prøv igen:");
			}
		} while(looping);
	}

	public void Menu_opretOpr(boolean adminMode, int ID) {
		System.out.println("Opret operatør");
		System.out.print("Indtast ID på ny operatør:");
		int newID = scan.nextInt();
		scan.nextLine();
		System.out.print("Indtast navn på ny operatør:");
		String name = scan.nextLine();
		System.out.print("Indtast CPR på ny operatør:");
		String cpr = scan.nextLine();
		//SPØRG OM PW OG VALIDÉR
		System.out.print("Indtast password for ny operatør (skal overholde DTU's regler for password):");
		String pw = "password";
		while (true) {
			pw = scan.nextLine();
			if (passf.validatePw(pw)) {
				break;
			} else {
				System.out.print("Det indtastede overholder ikke DTU's regler for password! Prøv igen:");
			}
		}
		try {
			userf.addOperator(newID, name, cpr, pw);
		} catch (DALException e) {
			System.out.println("ID eller CPR eksisterede allerede!");
			Menu_opretOpr(adminMode, newID);
		}
		System.out.println("Operatør oprettet!");
		Menu_oprAdmin(adminMode, ID);
	}

	public void Menu_visOpr(boolean adminMode, int ID) {
		System.out.println("Vis operatører");
		userf.showOperators();
		System.out.println("1) Tilbage til Operatør Administration");
		if (scan.nextInt() == 1) {
			Menu_oprAdmin(adminMode, ID);
		}
	}

	public void Menu_changePw(boolean adminMode, int ID) {
		System.out.print("Indtast dit nuværende password:");
		scan.nextLine();
		String currentPw;
		while(true) {
			try 
			{
				currentPw = scan.nextLine();
				if (userf.checkPassword(ID, currentPw)) break; 
			}
			catch (Exception e) {
				System.out.print("Forkert password, prøv igen:");
			}
		}
		System.out.print("Indtast dit nye password (skal overholde DTU's regler for password):");
		String newPw = scan.nextLine();
		while (!passf.validatePw(newPw)) {
			System.out.print("Det indtastede overholder ikke DTU's regler for password! Prøv igen:");
			newPw = scan.nextLine();
		}
		System.out.print("Indtast dit nye password igen:");
		String newPw2 = scan.nextLine();
		while (!newPw2.equals(newPw)) {
			System.out.print("Det to password stemmer ikke overens! Prøv igen:");
			newPw2 = scan.nextLine();
		}

		System.out.println("Dit password er skiftet!");
		Menu_main(adminMode, ID);
	}

	public void Menu_weight(boolean adminMode, int id) {
		System.out.println("Vægt");
		System.out.print("Indtast tara vægt i kg: ");
		double tara = scan.nextDouble();
		scan.nextLine();
		System.out.print("Indtast brutto vægt i kg: ");
		double brutto = scan.nextDouble();
		System.out.println("Netto vægt i kg: "+(tara+brutto)+"\n");
		Menu_main(adminMode, id);
	}
	
}
