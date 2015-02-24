package functionality;

import data.UserData.Operatoer;

public interface IUserFunktion {
	boolean checkExists(int ID);
	void addOperator(int newID, String name, String cpr, String pw);
	void showOperators();
	boolean changePassword(int ID, String pw);
	public Operatoer getOperatorByID(int ID);
	void removeOperator(int ID);
}
