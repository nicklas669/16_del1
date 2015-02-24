package functionality;

import data.IUserData.DALException;
import data.UserData.Operatoer;

public interface IUserFunktion {
	
	boolean checkExists(int ID) throws DALException;
	void addOperator(int newID, String name, String cpr, String pw) throws DALException;
	void showOperators() throws DALException;
	boolean changePassword(int ID, String pw) throws DALException;
	public Operatoer getOperatorByID(int ID) throws DALException;
	void removeOperator(int ID) throws DALException;
}
