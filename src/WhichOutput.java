// Currently the output prints 00 with high probability

// How to force specific output orders?
// 00 01 10(possible?) 11 12 21 (possible?) 22

// what about 20, is it possible?

// How to to the same using join()?

public class WhichOutput extends Thread	{

	static int shared = 0;
	int id;

	static String s(int ms) {
		try { sleep(ms); } catch (Exception e) {};
		return " ";
	}

	static String j(Thread t) {
		try { t.join(); } catch (Exception e) {};
		return " ";
	}

	public WhichOutput(int id) {
		this.id = id;
	}

	public int getShared() {
		return shared;
	}

	public void compute()	{
		if ( id == 1 )	{
			s(100);
			shared = 1;
		}
		if ( id == 2 )	{
			s(200);
			shared = 2;
		}
	}

	public void run () {
		compute();
	}

	public static void main (String args []) {
		WhichOutput aT1  = new WhichOutput(1);
		WhichOutput aT2  = new WhichOutput(2);
		// using sleep
		aT1.start();
		aT2.start();
		System.out.println(s(0) + aT1.getShared() + s(0) + aT2.getShared());


//		// using join
//		aT1.start();
////		j(aT1);
//		aT2.start();
////		j(aT2);
//		System.out.println( aT1.getShared() + " " + aT2.getShared());
	}
}
