package functionality;

import data.IUserData;
import data.UserData;
import data.UserData.Operatoer;

public class UserFunktion implements IUserFunktion {
	IUserData data;
	public UserFunktion(IUserData data) {
		this.data = data;
	}


	@Override
	public void removeOperator(int ID) {
		data.getOperatoerArray().remove(getOperatorByID(ID).getID());
	}

	@Override
	public boolean checkExists(int ID) {
		for (UserData.Operatoer opr:data.getOperatoerArray()) {
			if (opr.getID() == ID) {
				return true; // ID eksisterer allerede
			}
		}
		return false;
	}


	@Override
	public void addOperator(int newID, String name, String cpr, String pw) {
		data.addOperator(newID, name, cpr, pw);
	}


	@Override
	public void showOperators() {
		for (Operatoer opr : data.getOperatoerArray()) {
			System.out.println(opr);
		}
	}
	public Operatoer getOperatorByID(int ID) {
		for (UserData.Operatoer opr:data.getOperatoerArray()) {
			if (opr.getID() == ID) {
				return opr;
			}
		}
		return null;
	}
	
	public boolean changePassword(int ID, String pw) {
		for (UserData.Operatoer opr:data.getOperatoerArray()) {
			if (opr.getID() == ID) {
				if (opr.getPw().equals(pw)) return true;
				else {
					System.out.println("Forkert password!");
					return false;
				}
			}
		}
		return false;
	}
}
