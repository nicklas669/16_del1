import java.util.ArrayList;


public class UserData implements IUserData {
	private ArrayList<Operatoer> operatoerer;
	
	public UserData() {
		operatoerer.add(new Operatoer(20, "Mogens", "123456-7890"));
		operatoerer.add(new Operatoer(21, "Jens", "123456-7880"));
		operatoerer.add(new Operatoer(22, "B�rge", "123456-7870"));
	}
	
	public class Operatoer {
		int id;
		String name, cpr, pw;
		Password pass = new Password();
		
		public Operatoer(int id, String name, String cpr) {
			this.id = id;
			this.name = name;
			this.cpr = cpr;
			this.pw = pass.generatePw();
		}
	}
	
	public class Sysadmin {
		final int id = 10;
		final String name = "Sysadmin";
		final String cpr = "111111-1111";
		final String pw = ">02324it!<";
		
		public Sysadmin() {
			
		}
	}
	
	public class Password {
		public Password() {
			
		}
		
		public String generatePw() {
			return "azAZ19!";
		}
		
		public void setPw(String pw) {
			
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNavn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCPR() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String setNavn(String navn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setCPR(String cpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setPw(String pw) {
		// TODO Auto-generated method stub
		return null;
	}
}