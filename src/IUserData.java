import java.util.ArrayList;

import UserData.Operatoer;


public interface IUserData {
	public int getID();
	public String getNavn(int id);
	public String getCPR(int id);
	public String getPw(int id);
	public ArrayList<Operatoer> getOperatoerArray();
	public int setID(String id);
	public String setNavn(String navn);
	public String setCPR(String cpr);
	public String setPw(String pw);
}
