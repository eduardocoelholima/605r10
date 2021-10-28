import java.util.Vector;

class Line {
	int length;
	Line()	{}
	Line(int length)	{
		this.length = length;
	}
	int length()	{
		return length;
	}
}
class Square extends Line {
	Square()	{}
	Square(int length)	{
		super(length);
	}
	int length()	{
		return 4 * super.length();
	}
}
class Cube extends Square {
	Cube()	{}
	Cube(int length)	{
		super(length);
	}
	int length()	{
		return 3 * super.length();
	}
}
class ThreeDcube extends Cube {
	ThreeDcube()	{}
	ThreeDcube(int length)	{
		super(length);
	}
	int length()	{
		return 3 * super.length();
	}
}

class List<T> {
    Vector<T> myList = new Vector<T>();

    public void add( T anTlement ) {
    	myList.add(anTlement);
    }
    public T first() {
	if ( ! myList.isEmpty() )	{
		return myList.remove(0) ;
	} else  {
		return null;
	}
    }
    public boolean isEmpty()	{
	return myList.isEmpty();
    }
}
public class Test<T> {
	void print(List<T> aList)	{
		while ( !  aList.isEmpty() )	{
			System.out.println(aList.first());
			// aList.remove(0);
		}
	}
	int sum(List<? extends Cube> aList )	{
		int value = 0;
		while ( !  aList.isEmpty() )	{
			value +=  aList.first().length();
		}
		return value;
	}
	public static void main(String args[] )	{
		List<Line> aListOfLines = new List<Line>();			// Line
		List<Square> aListOfSquares = new List<Square>();		// Square
		List<Cube> aListOfCubes = new List<Cube>();			// Cube
		List<ThreeDcube> aListOfThreeDcubes = new List<ThreeDcube>();	// ThreeDcubes
		List<? super Line> aListSuperLine = new List<>();
		List<? super Cube> aListSuperCube = new List<>();

		aListSuperLine.add(new Line(3) ); aListSuperLine.add(new Square(3) );
		aListSuperLine.add(new Cube(3) ); aListSuperLine.add(new ThreeDcube(3) );
		new Test().print(aListSuperLine);

		aListSuperCube.add(new Cube(3) ); aListSuperCube.add(new ThreeDcube(3) );
		System.out.println(new Test().sum(aListSuperCube));
/*
		new Test().sum(aListOfLines);
Test.java:71: error: incompatible types: List<Line> cannot be converted to List<? extends Square>
		new Test().sum(aListOfLines);
		               ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error

shell returned 1
*/
	}
}

