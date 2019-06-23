package ch05pc17;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author FRANK.OLSON
 * date 11/8/2017
 * purpose: to play Rock, Paper, Scissors
 */
public class Ch05pc17 {

    public static void main(String[] args) {
        //variables
        int selection;
        String compResult, userResult, result, cont;
        boolean winner = false;
        
        //create a scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);
        
        while(!winner)
        {
            //Call the rockPaperScissors method
            compResult = compRandomGen();
        
            //display the menu
            displayMenu();
            selection = keyboard.nextInt();

            //get user result
            userResult = rockPaperScissors(selection);

            //check results
            result = rpsRules(compResult, userResult);
            
            //show the computer's selection
            System.out.println("The computer chose: " + compResult);


            if (result.equals("Tie") || result.equals("error") || result.equals(""))
            {
                winner = false;
                System.out.println("There was no clear winner this round.");
                System.out.println(result);
            }
            else
            {
                winner = true;
                System.out.println(result);
                
                System.out.print("Do you want to play again? Y/N");
                cont = keyboard.nextLine();
                
                if (cont.equalsIgnoreCase("Y"))
                    winner = false;
              
            }
            
            
        }
        
        
    }
    
    /**
     * 
     * @return rpsResult the computer generated result
     */
    public static String compRandomGen ()
    {
        //variables
        int rps;
        String rpsResult;
        
        //create a Random class object
        Random randomNumber = new Random();
        rps = randomNumber.nextInt(3) + 1;
        
        rpsResult = rockPaperScissors(rps);
        return rpsResult;
    }
    
    /**
     * Displays the menu selection
     */
    public static void displayMenu ()
    {
        System.out.println("Please make your selection: ");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
    }
    
    /**
     * 
     * @param rps the integer of the selection
     * @return rpsResult String result of the selection
     */
    public static String rockPaperScissors(int rps)
    {
        //variables
        String rpsResult;
        
        switch (rps)
        {
            case 1:
                rpsResult = "Rock";
                break;
            case 2:
                rpsResult = "Paper";
                break;
            case 3:
                rpsResult = "Scissors";
                break;
            default:
                rpsResult = "Error";
                break;
        }
        
        return rpsResult;
    }
    
    /**
     * 
     * @param comp the computer's selection (rock, paper, or scissors)
     * @param user the user's selection (rock, paper, or scissors)
     * @return result the result of the playoff
     */
    public static String rpsRules(String comp, String user)
    {
        //variables
        String result = "";
        
        //Rock > Scissors
        //Scissors > Paper
        //Paper > Rock
        
        if (comp.equals(user))
            result = "Tie";
        else if (comp.equals("Rock"))
        {
            if (user.equals("Scissors"))
                result = "Computer wins.  Rock crushes Scissors.";
            else if (user.equals("Paper"))
                result = "You win.  Paper wraps Rock.";
        }
        else if (comp.equals("Paper"))
        {
            if (user.equals("Rock"))
                result = "Computer wins.  Paper wraps Rock.";
            else if (user.equals("Scissors"))
                result = "You win.  Scissors cut Paper.";
        }
        else if (comp.equals("Scissors"))
        {
            if (user.equals("Rock"))
                result = "You win.  Rock smashes Scissors.";
            else if (user.equals("Paper"))
                result = "Computer wins.  Scissors cut Paper.";
        }
        else
            result = "error";
        
        return result;
    }
    
    
}
