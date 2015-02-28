package data;
import java.util.ArrayList;
import java.util.Random;

import data.IUserData.DALException;


public class UserData implements IUserData {
	private ArrayList<Operatoer> operatoerer = new ArrayList<Operatoer>();
	
	public UserData() {
		operatoerer.add(new Operatoer(10, "Sysadmin", "111111-1111", ">02324it!<"));
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
		
		public String getName() {
			return this.name;
		}

		public void setPw(String newPw1) {
			this.pw = newPw1;
		}
	}
	
	
	public class Password {
		public Password() {
			
		}
		
		public String generatePw() {
//			Random rnd = new Random();
			String pw = "aaAA11";
			return pw;
		}
	}

	@Override
	public int getID(String cpr) throws DALException {
		for (Operatoer opr : operatoerer) {
			if (opr.cpr ==cpr){
				return opr.id;
			}
		}
		throw new DALException();
	}

	@Override
	public String getNavn(int id) throws DALException {
		for (Operatoer opr : operatoerer) {
			if (opr.id == id){
				return opr.name;
			}
		}
		throw new DALException();
	}

	@Override
	public String getCPR(int id) throws DALException {
		for (Operatoer opr : operatoerer) {
			if (opr.id == id){
				return opr.cpr;
			}
		}
		throw new DALException();
	}

	@Override
	public String getPw(int id) throws DALException {
		for (Operatoer opr : operatoerer) {
			if (opr.id == id){
				return opr.pw;
			}
		}
		throw new DALException();
	}

	@Override
	public ArrayList<Operatoer> getOperatoerArray() {
		// TODO Auto-generated method stub
		return operatoerer;
	}
	
	public void createOperatoer(int id, String name, String cpr, String pw) throws DALException{
		for (Operatoer opr : operatoerer) {
			if(opr.id == id) throw new DALException();
			if(opr.cpr == cpr) throw new DALException();
		}
		if (name.length()>20) throw new DALException();
		this.operatoerer.add(new Operatoer(id, name, cpr, pw));
	}
	
	@Override
	public void setPw(int id, String pw) throws DALException {
		for (Operatoer opr : operatoerer) {
			if(opr.id == id) {
				opr.pw = pw;
			}
		}
		throw new DALException();
		
	}
	
	@Override
	public Operatoer getOperatoer(int id) throws DALException {
		if (id<10 || id>99) throw new DALException(); 
		for (Operatoer opr:operatoerer) {
			if (opr.getID() == id) return opr;
		}
		throw new DALException();
	}
	
	
	@Override
	public void updateOperatoer(Operatoer opr) throws DALException {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeOperatoer(int id) throws DALException {
		if (id == 10) throw new DALException();
		for (Operatoer opr:operatoerer) {
			if (opr.getID() == id) {
				operatoerer.remove(opr);
				return;
			}
		}
		throw new DALException();
	}

//	@Override
//	public void setID(int currID, int newID) throws DALException {
//		for (Operatoer opr:operatoerer) {
//			if (opr.getID() == currID) {
//				opr.id = newID;
//				return;
//			}
//		}
//		throw new DALException();
//	}

//	@Override
//	public String setNavn(String navn) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String setCPR(String cpr) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
