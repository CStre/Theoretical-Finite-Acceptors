// Finite State Machine
// Counts the number of occurrences of 5 words: 
// late, least, asset, settle, stale 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program2 {

   private static final int lateACCEPT = 14;  
   private static final int leastACCEPT = 19;  
   private static final int assetACCEPT = 20;  
   private static final int settleACCEPT = 23;
   private static final int staleACCEPT = 22;

   //   S  E  T  L  A  ?
   private static final int[][] STATE_TABLE = {
       {3, 0, 0, 1, 2, 0},	// state 0
       {3, 5, 0, 1, 4, 0},	// state 1
       {6, 0, 0, 1, 2, 0},	// state 2
       {3, 7, 8, 1, 2, 0},	// state 3
       {3, 0, 9, 1, 2, 0},	// state 4
       {3, 0, 0, 1, 10, 0},	// state 5
       {11, 3, 8, 1, 2, 0},	// state 6
       {3, 0, 12, 1, 2, 0},	// state 7
       {3, 0, 0, 1, 13, 0},	// state 8
       {3, 14, 0, 1, 2, 0},	// state 9
       {15, 0, 0, 1, 0, 0},	// state 10
       {3, 16, 8, 1, 2, 0},	// state 11
       {3, 0, 17, 1, 2, 0},	// state 12
       {6, 0, 0, 18, 2, 0},	// state 13
       {3, 0, 0, 1, 2, 0},	// state 14
       {11, 7, 19, 1, 2, 0},	// state 15
       {3, 0, 20, 1, 2, 0},	// state 16
       {3, 0, 0, 21, 2, 0},	// state 17
       {3, 22, 0, 1, 4, 0},	// state 18
       {0, 0, 0, 0, 13, 0},	// state 19
       {3, 0, 17, 1, 2, 0},	// state 20
       {3, 23, 0, 1, 4, 0},	// state 21
       {3, 0, 0, 1, 10, 0},	// state 22
       {3, 0, 0, 1, 10, 0},	// state 23
   };

    private BufferedReader in;
    private int lateCount; 
    private int leastCount;
    private int assetCount;
    private int settleCount;
    private int staleCount;


    public Program2(String filename) throws IOException {
        in = new BufferedReader(
                 new FileReader(filename));
       lateCount = 0; 
       leastCount = 0;
       assetCount = 0;
       settleCount = 0;
       staleCount = 0;
    }


    public void run() throws IOException {
        char ch;
        int unicode;
        int state = 0;

        unicode = in.read();
        while (unicode != -1) {
           ch    = (char) unicode;
           state = STATE_TABLE[state][charToColumn(ch)];
           if (state == lateACCEPT) {
              lateCount++;
           }
           if (state == leastACCEPT) { 
              leastCount++;
           }
           if (state == assetACCEPT) { 
              assetCount++;
           }
           if (state == settleACCEPT) { 
              settleCount++;
           }
           if (state == staleACCEPT) {
        	   staleCount++;
           }
           unicode = in.read();
        }
        System.out.println( "Occurrence counts: ");
        System.out.println( "late	count is " + lateCount);
        System.out.println( "least	count is " + leastCount);
        System.out.println( "asset	count is " + assetCount);
        System.out.println( "settle	count is " + settleCount);
        System.out.println( "stale	count is " + staleCount);
    }

    public int charToColumn(char ch) {
        if (ch == 'S' || ch == 's') 
           return 0;
        if (ch == 'E' || ch == 'e') 
           return 1;
        if (ch == 'T' || ch == 't') 
           return 2;
        if (ch == 'L' || ch == 'l') 
           return 3;
        if (ch == 'A' || ch == 'a') 
           return 4;
        return 6;
    }

    public static void main(String[] args) {
        if (args.length < 1)
           System.out.println 
                ("Run again, entering a filename at the commandline");
        else {
           try {
               Program2 fsm = new Program2(args[0]);
               fsm.run();
           } catch (IOException ex) {
               ex.printStackTrace();
               System.exit(1);
           }
       }
    }
}
