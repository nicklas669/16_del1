package functionality;

import data.IUserData.DALException;
import data.UserData.Operatoer;

public interface IUserFunktion {
	
	boolean checkExists(int ID) throws DALException;
	void addOperator(int newID, String name, String cpr, String pw)throws DALException;
	void showOperators();
	boolean checkPassword(int ID, String pw) throws DALException;
	Operatoer getOperatorByID(int ID) throws DALException;
	String getNameById(int ID) throws DALException;
	void removeOperator(int ID) throws DALException;
}
