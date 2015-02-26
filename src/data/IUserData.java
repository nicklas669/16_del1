package data;
import java.util.ArrayList;


public interface IUserData {
	public UserData.Operatoer getOperatoer(int id) throws DALException;
	public int getID(String cpr) throws DALException;
	public String getNavn(int id) throws DALException;
	public String getCPR(int id) throws DALException;
	public String getPw(int id) throws DALException;
	public ArrayList<UserData.Operatoer> getOperatoerArray();
	public void setPw(int id, String pw) throws DALException;
	void createOperatoer(int id, String name, String cpr, String pw) throws DALException;
	void updateOperatoer(UserData.Operatoer opr) throws DALException;
	
	
//	public void setID(int currID, int newID) throws DALException;
//	public String setNavn(String navn) throws DALException;
//	public String setCPR(String cpr) throws DALException;
	
	public class DALException extends Exception {
		
		public DALException() {
			
		}
	}
}
