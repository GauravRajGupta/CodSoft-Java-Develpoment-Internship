import java.util.Scanner;
import java.util.Random;

public class _1NumberGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int randomNum = random.nextInt(101);

        System.out.println("******************************[You're Welcomed to our Number Guessing Game]******************************");

        int attempts = 10, rounds = 0, score = 0;
        boolean game = true;

        //Loop for Rounds !
        while(game){
            rounds += 1;

            while(attempts !=0){
                System.out.print("Enter your guessed number (to match with the random number) between 0 to 100 : ");
                int gamerNum = sc.nextInt();

                if(gamerNum<0 || gamerNum>100 ){
                    System.out.println("***Entered number is out of range !***");
                    continue;
                }

                if(gamerNum == randomNum){
                    System.out.println("***************Congratulations ! You have guessed right number !***************");
                    score += attempts;
                    attempts = 10;                                                                         //initializing attempts=10 for the new 10 attempts in the next round.
                    randomNum = random.nextInt(101);                                                //initializing new random number in randomNum variable for the next round.
                    break;
                }
                else if(gamerNum > randomNum){
                    System.out.println("***Unmatched, Please Guess More Lower Number !***");
                    attempts -= 1;
                }
                else{
                    System.out.println("***Unmatched, Please Guess More Higher Number !***");
                    attempts -=1;
                }

                if(attempts == 0){
                    System.out.println("***** Sorry, you have tried all your attempts ! ***** The random number to be guessed was "+randomNum+" ! *****");
                }
            }

            //Code for next round if user wants to play.
            System.out.println("Do you want to try playing again ? [Enter 1 for YES or 0 for NO]");
            int nextRound = sc.nextInt();
            if(nextRound != 1){
                System.out.println("YOU HAVE PLAYED "+rounds+" ROUNDS & YOUR TOTAL SCORE IS "+score+" !");
                game = false;
            }

        }



    }
}