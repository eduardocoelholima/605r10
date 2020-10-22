import java.io.*;
import java.util.*;

public class Password implements Serializable {
  private int MINIMUMlength = 10;
  private String password;
  private int    hashCode;

  public Password(String password)	{
		this.password = password;
	        this.hashCode = password.hashCode();
  }
  private void writeObject(ObjectOutputStream s) throws IOException {
	System.out.println("Password: writeObject");
	s.defaultWriteObject();
        s.writeObject(password);
        s.writeObject(hashCode);
  }

  private void readObject(ObjectInputStream s) throws IOException  {
	System.out.println("Password: readObject");
	try {
         	s.defaultReadObject();
		String password = (String)s.readObject();
		int    hashCode = (int)s.readObject();
		if ( this.password.hashCode() != hashCode )
			this.password = "";
	}
        catch ( ClassNotFoundException e)	{
    	    System.out.println(e.getMessage());
    	    e.printStackTrace();
        }
  }
  public String toString()	{
	return password;
  }

}
