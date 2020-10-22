//This program executes the thread in no particular order (scheduler defined)

//1 Can we force it to be executed in the order the arguments were passed? How
// to do it with sleep methods?

//2 What if we use join methods, can we force it to be sequential?

//3 What if we want to make it execute arguments in descending order using
// sleep?

//4 What about using join?

import static java.lang.Thread.sleep;

public class WhichOrder implements Runnable {

	private String info;
	int x = 0;

	public WhichOrder(String info) {
		this.info = info;
	}

	public void run () {
		x=1;
		try {
			int waitTime = Integer.valueOf(info)*10;
//			System.out.println("waitTime="+waitTime);
			sleep(waitTime);
		} catch (InterruptedException e) {
		}
		System.out.print(info);
	}

	public static void main (String args []) {
		if (args != null)	{
			for (int n = 0; n < args.length; ++ n)	{

				Thread x = new Thread( new WhichOrder("" + n ) );
				x.start();
//				try {
//					x.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}

			}
		}
	}
}
