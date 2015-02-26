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
		data.removeOperatoer(ID);
	}

	@Override
	public boolean checkExists(int ID) throws DALException {
		if (data.getOperatoer(ID) != null) return true;
		return false;
	}


	@Override
	public void addOperator(int newID, String name, String cpr, String pw) throws DALException{
		data.createOperatoer(newID, name, cpr, pw);
	}


	@Override
	public void showOperators() {
		for (Operatoer opr : data.getOperatoerArray())  {
			System.out.println(opr);
		}
	}
	
	public String getNameById(int ID) throws DALException {
		String output = data.getNavn(ID);
		return output;
	}
	
	public Operatoer getOperatorByID(int ID) throws DALException {
		for (UserData.Operatoer opr:data.getOperatoerArray()) {
			if (opr.getID() == ID) {
				return opr;
			}
		}
		return null;
	}
	
	public boolean checkPassword(int ID, String pw) throws DALException {
		if (data.getPw(ID).equals(pw)) return true;
		else throw new DALException();
	}
}
