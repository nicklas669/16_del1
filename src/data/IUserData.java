package data;
import java.util.ArrayList;


public interface IUserData {
	public int getID();
	public String getNavn(int id);
	public String getCPR(int id);
	public String getPw(int id);
	public ArrayList<UserData.Operatoer> getOperatoerArray();
	public int setID(String id);
	public String setNavn(String navn);
	public String setCPR(String cpr);
	public String setPw(String pw);
	void addOperator(int id, String name, String cpr, String pw);
}
