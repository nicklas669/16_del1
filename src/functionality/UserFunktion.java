package functionality;

import data.IUserData;
import data.IUserData.DALException;
import data.UserData;
import data.UserData.Operatoer;

public class UserFunktion implements IUserFunktion {
	IUserData data;
	public UserFunktion(IUserData data) {
		this.data = data;
	}


	@Override
	public void removeOperator(int ID) throws DALException {
		data.getOperatoerArray().remove(getOperatorByID(ID) );
	}

	@Override
	public boolean checkExists(int ID) throws DALException {
		for (UserData.Operatoer opr : data.getOperatoerArray()) {
			if (opr.getID() == ID) {
				return true;
			}
		}
		throw new DALException();
	}


	@Override
	public void addOperator(int newID, String name, String cpr, String pw) throws DALException {
		data.addOperator(newID, name, cpr, pw);
	}


	@Override
	public void showOperators() throws DALException {
		for (Operatoer opr : data.getOperatoerArray())  {
			System.out.println(opr);
		}
	}
	public Operatoer getOperatorByID(int ID) throws DALException {
		for (UserData.Operatoer opr:data.getOperatoerArray()) {
			if (opr.getID() == ID) {
				return opr;
			}
		}
		return null;
	}
	
	public boolean changePassword(int ID, String pw) throws DALException {
		for (UserData.Operatoer opr:data.getOperatoerArray())  {
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
