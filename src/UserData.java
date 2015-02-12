import java.util.ArrayList;


public class UserData implements IUserData {
	private ArrayList<Operatoer> operatoerer = new ArrayList<Operatoer>();
	
	public UserData() {
		operatoerer.add(new Operatoer(10, "Sysadmin", "111111-1111", "1")); //>02324it!<
		operatoerer.add(new Operatoer(20, "Mogens", "123456-7890"));
		operatoerer.add(new Operatoer(21, "Jens", "123456-7880"));
		operatoerer.add(new Operatoer(22, "Børge", "123456-7870"));
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
		
		public Operatoer(int id, String name, String cpr, String pw) {
			this.id = id;
			this.name = name;
			this.cpr = cpr;
			this.pw = pw;
		}
		
		public String toString() {
			return id+"     "+name+"     "+cpr;
		}
		
		
		public int getID() {
			return this.id;
		}
		
		public String getPw() {
			return this.pw;
		}
	}
	
	
	public class Password {
		public Password() {
			
		}
		
		public String generatePw() {
			return "2";
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
	public String getNavn(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCPR(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPw(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Operatoer> getOperatoerArray() {
		// TODO Auto-generated method stub
		return operatoerer;
	}
	
	public void addOperator(int id, String name, String cpr) {
		this.operatoerer.add(new Operatoer(id, name, cpr));
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
