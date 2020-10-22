import java.io.*;
import java.util.*;

public class PasswordWrite {

  public static void main( String args[] ) {

    Password aPassword = new Password("abcdef");
    String fileName    = "1234.ser";

    if ( args.length == 1 )
        fileName = args[0];

    try (
        ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(fileName) );
	) {
        p.writeObject(aPassword);
    }
    catch ( IOException e)	{
    	System.out.println(e.getMessage());
	e.printStackTrace();
    }
 
  }
}
