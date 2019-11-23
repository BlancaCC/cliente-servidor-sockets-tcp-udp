import java.util.HashMap;

public class Memories {

    private static HashMap<String, String> users = new HashMap<String, String>();

    //if a users exists
    public boolean userExists(String name){
	boolean ret = true;
	if(users.get(name) == null)
	    ret = false;

	return ret; 
    }

    public void addUser(String name, String pass){
	users.put(name,pass); 
    }

    public Boolean correctPassword(String name, String pw){
	return (users.get(name)==pw);
    }
    
}
