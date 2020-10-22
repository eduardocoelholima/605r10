// https://data.ny.gov/Government-Finance/Lottery-Pick-10-Winning-Numbers-Beginning-1987/bycu-cw7c
// Choose ten numbers from 1 to 80.
// File sttructure
// Draw Date,Winning Numbers
// 09/30/2020,01 04 07 10 16 19 28 34 36 40 46 47 51 52 59 62 64 67 72 77

import java.util.zip.GZIPInputStream;
import java.io.*;

public class NumberCounter {
 
	static String fileName = null;
	Reader input;
	final int    soManyNumbersAreUsed = 80;
	final int    soManyColumns = 2;
	int[]  theNumbers = new int[soManyNumbersAreUsed + 1 ];

	public NumberCounter(String fileName) {
		this.fileName = fileName;
	}
	private void printResult()	{
		for ( int index = 0; index < theNumbers.length/soManyColumns; index += soManyColumns )	{
			for ( int column = 0; column <= soManyColumns ; column++ )	{
				int whichNumber = 1 + index * soManyColumns + column;
				System.out.print(whichNumber + ":	" + theNumbers[whichNumber] + "	");
			}
			System.out.println();
		}
	}
	private void processOneLine(String theLine)	{
		// System.out.println(theLine );
		theLine = theLine.substring(theLine.indexOf(",") + 1, theLine.length() );
		String[] individualContent = theLine.split("\\s");
		for ( int index = 0; index < individualContent.length; index++ )	{
			theNumbers[Integer.valueOf(individualContent[index])] ++;
		}
	
	}
	private void processInput()	{
		try (
			BufferedReader input = new BufferedReader( ( fileName == null ? 
							new InputStreamReader(System.in) :
							new InputStreamReader( ( fileName.endsWith(".gz" ) ?
									new GZIPInputStream(new FileInputStream(fileName) ) :
									new FileInputStream(fileName) )  )
									      )
							         );
		    ) {
			String oneLine = input.readLine();
			while ( ( oneLine = input.readLine() ) != null )	{
				// System.out.println(oneLine);
				processOneLine(oneLine);
			}
			printResult();
		} catch ( Exception e )	{
			e.printStackTrace();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		NumberCounter aNumberCounter = new NumberCounter(args.length == 1 ? args[0] : null);
		aNumberCounter.processInput();
	}
}
