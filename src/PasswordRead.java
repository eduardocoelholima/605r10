import java.io.*;
import java.util.*;

public class PasswordRead {

    public static void main( String args[] ) {

        Password aPassword;
        String fileName = "1234.ser";

        if ( args.length == 1 )
            fileName = args[0];
        try (
                ObjectInputStream p = new ObjectInputStream(new FileInputStream(fileName) );
        ) {
            aPassword = (Password)p.readObject();
            System.out.println("aPassword = " + aPassword );
        }
        catch ( IOException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch ( ClassNotFoundException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
