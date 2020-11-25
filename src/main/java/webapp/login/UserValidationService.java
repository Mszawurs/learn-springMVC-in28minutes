package webapp.login;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if(user.equals("abba") && password.equals("pass")){
			return true;
		}
		return false;
	}
}
