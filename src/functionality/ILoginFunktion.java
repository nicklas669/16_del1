package functionality;

import data.IUserData.DALException;

public interface ILoginFunktion {
	int login() throws DALException;
	int login(int ID)throws DALException;
}
