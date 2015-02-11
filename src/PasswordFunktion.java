
public class PasswordFunktion {
	public PasswordFunktion() {
	}

	public boolean validatePw(String input) {
		
		//INDSÆT KODE FOR TJEK OM ET NYT PASSWORD ER GYLDIGT HER
		char[] pw = input.toCharArray();
		int upper = 0, lower = 0, numbers = 0, symbols = 0, categories = 0;
		boolean valid = true;
		
		if (input.length() >= 6) {
			for (char chr:pw) {
				if (chr >= 65 && chr <= 90) upper++;// A-Z
				else if (chr >= 97 && chr <= 122) lower++;// a-z
				else if (chr >= 48 && chr <= 57) numbers++;// 0-9
				else if (chr == 95 || chr == 46 || chr == 45 || chr == 44 || chr == 33 || chr == 63 || chr == 61 || chr == 43) symbols++;// .-,_+!?=
				else valid = false;
			}
			
			if (upper > 0) categories++;
			if (lower > 0) categories++;
			if (numbers > 0) categories++;
			if (symbols > 0) categories++;
		}	
		if (categories >= 3 && valid) {
			return true;
		} else { return false; }
	}
}
