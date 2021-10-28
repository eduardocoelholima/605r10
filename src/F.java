/*
- This program does not compile as is. Why?
Method noSystemExit() has an unreachable return statement.
(line 22)
- Explain the execution of each method in writing. You have to name the file
27_3.txt
Comments provided before each method.
 */
public class F {

    // This method will throw an Exception, which will be caught by a single
    // catch block. The catch block will print "2" and set return value to 0.
    // Before actually returning, the finally block will be executed, "3..."
    // will be printed and a new return value of "1" will overwrite the
    // previous one.
    private int noSystemExit()	 {
        try {
            throw new Exception("1");
        } catch (Exception e)	{
            System.out.println("2");
            return 0;
        } finally	{
            System.out.println("3 finally");
            return 1;
        }
//		return 3;
    }

    // This method has a catch block that is not executed because no
    // Exception is thrown. Inside the try block, a return value is set, which
    // is latter overwritten by the return statement inside the finally block.
    private int noExeption()	 {
        try {
            int x = 1 - 1;
            System.out.println("inside try: 1");
            return x;
        } catch (Exception e)	{
            System.out.println("inside catch: 2");
            return 1;
        } finally	{
            System.out.println("inside finally: 3 ");
            return 2;
        }
    }

    // This method has a division by zero inside a try block, which throws a
    // runtime ArithmeticException. The catch block "captures" the exception,
    // then an index-out-of-bounds exception is thrown but no catch block
    // captures it, but the code inside of the catch block is interrupted and
    // then the finally block is executed.
    private int anExeption1()	 {
        int[] anArray  = new int[1];
        try {
            System.out.println("inside try: 1");
            anArray[2] = 1 / 0;
            return 0;
        } catch (ArithmeticException e)	{
            anArray[2] = 0;
            System.out.println("inside catch: 2");
            return 1;
        } finally	{
            System.out.println("inside finally: 3 ");
            return 2;
        }
//		 return 3;
    }

    // This method will do an out-of-bounds array element assignment inside a
    // try block, which will throw an IndexOutOfBoundsException. No catch
    // block will capture it, so the finally block will be executed and a
    // value will be returned.
    private int anExeption2()	 {
        int[] anArray  = new int[1];
        try {
            anArray[2] = 0;
            anArray[2] = 1 / 0;
            System.out.println("inside try: 1");
            return 0;
        } catch (ArithmeticException e)	{
            System.out.println("inside catch: 2");
            return 1;
        } finally	{
            System.out.println("inside finally: 3 ");
            return 2;
        }
//		 return 3;
    }

    // This method will throw a general Exception, which will be caught by
    // the catch block. The catch block will call a System.exit() which will
    // abruptly terminate the program, even without executing the finally
    // block, which would otherwise be ran.
    private void withSystemExit()	 {
        try {
            throw new Exception("4");
        } catch (Exception e)	{
            System.out.println("5");
            System.exit(0);
        } finally	{
            System.out.println("6 finally");
        }
        System.out.println("exit(): you will not see this line");	// not exectuted
    }

    // Try to comment and uncomment each method below
    public static void main(String[] args) {
//		int r = new F().noSystemExit();
//		System.out.println(new F().noSystemExit()); // same as before, plus
//		new F().noExeption();
//		System.out.println(new F().anExeption1() );
//		new F().anExeption2();
//		new F().withSystemExit();
    }
}