import java.util.HashMap;
import java.util.HashSet;

public class Memories {

    private static HashMap<String, String> users = new HashMap<String, String>();
    private String user =""; //user to asociate contents
    
    //contents
    private static HashMap<String, HashSet<String>> content =
	new HashMap<String, HashSet <String> >(); 


    // ############# funtions ################ 
    //if a users exists
    public boolean userExists(String name){
	boolean ret = true;
	if(users.get(name) == null)
	    ret = false;

	return ret; 
    }

    public void addUser(String name, String pass){
	users.put(name,pass);
	content.put(name, new HashSet<String>());
    }

    public boolean correctPassword(String name, String pw){
	user = name; //save this name as actual user
	return (users.get(name)!=null && users.get(name).equals(pw));
    }

    public void addContent(String ms){
	System.out.println(user + ": " + ms); 
	(content.get(user)).add(ms);
    }


    
}
