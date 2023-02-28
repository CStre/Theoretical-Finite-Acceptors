import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Program1
{
	private final static int[][] STATE_TABLE = 
	{
 		{ 0, 2, 1, 10 },
 		{ 0, 3, 4, 10 },
 		{ 5, 2, 1, 10 },
 		{ 6, 2, 1, 10 },
 		{ 7, 3, 4, 10 },
 		{ 0, 8, 1, 10 },
 		{ 9, 8, 1, 10 },
 		{ 7, 7, 7, 10 },
 		{ 8, 8, 8, 10 },
 		{ 9, 9, 9, 10 },
 		{ 10, 10, 10, 10 },	
	};

	private BufferedReader in;

	public Program1() 
	{
		in = new BufferedReader(
			new InputStreamReader(System.in));
 	}

	public void run() throws IOException 
	{
 		char ch;
 		int state;
 		for (;;) 
		{
 			System.out.print("Enter your string: ");
		 	ch = (char) in.read();

 			// set state to start state
 			state = 0;
			while (ch != '\n') 
			{
 				state = STATE_TABLE[state][charToColumn(ch)];
 				ch = (char) in.read();
 			}
 		
			// determine whether to accept or reject
 			if (state == 7 || state == 8 || state == 9) 
			{
 				System.out.println("Accept\n");
 			} 
			else 
			{
 				System.out.println("Reject\n");
 			}
 		}
	}

 	public int charToColumn(char ch) 
	{
 		// column 3 is for some unexpected character
 		int column = 3; 
 
		switch( ch ) 
		{
 		case 'a':
 			column = 0;
 			break;
 	
		case 'b':
 			column = 1;
 			break;
 			
		case 'c':
			column = 2;
			break;
 		}
 	
		return column;
 	}
 
	public static void main(String[] args) 
	{
 		try 
		{
 			Program1 fsm = new Program1();
			fsm.run();
 		} 
		catch (IOException ex) 
		{
 			ex.printStackTrace();
 			System.exit(1);
 		}
 	}
}

