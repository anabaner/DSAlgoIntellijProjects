import java.util.Scanner;

public class Codingame1 {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String o = in.nextLine();

        // - Scissors win over Hand
        //- Hand win over Stone
        //- Stone win over Scissors
        // To debug: System.err.println("Debug messages...");
        if (o.equals("Hand"))
          System.out.println("Scissors");
        else if (o.equals("Stone"))
            System.out.println("Hand");
        else if (o.equals("Scissors"))
            System.out.println("Stone");
        else  System.out.println("Error");
    }

}
