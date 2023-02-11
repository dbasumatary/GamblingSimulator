package com.gamblingsimulator;
/*Print days won or lost each month and by how much*/
public class GamblingSimulator {
    public static final int EveryDayStake = 100;
    public static final int betEveryGame = 1;
    public void monthlyWinOrLose(){
        double upperMargin = 0.5 * EveryDayStake;                 // There is 50% margin after win or lose
        double lowerMargin = -0.5 * EveryDayStake;
        int winDays = 0, lossDays = 0, drawDays = 0;              //Instantiate new variables
        for (int i = 0; i < 20; i++){                                // The gambler plays for 20 days
            double dailyAmount = 0;
            int betPlayed = 0;                                   //Start initial with 0 and then to 100 bets
            /*The dailyAmount has to be in between the two margins of 50% and betPlayed has to be from 0 to 100*/
            while ((dailyAmount < upperMargin) && (dailyAmount > lowerMargin) && (betPlayed < EveryDayStake)){
                double random = Math.random();
                betPlayed++;
                if (random > 0.5){
                    dailyAmount += betEveryGame;
                }else{
                    dailyAmount -= betEveryGame;
                }
            }
            if (dailyAmount > 0){                                            //Printing the daily amount for wins
                winDays++;
                System.out.println("Day "+ i + ": The amount won is $" + dailyAmount);
            }
            else if (dailyAmount == 0){                                     //Printing the daily amount for draw
                drawDays++;
                System.out.println("Day "+ i +": There is no net gain or loss ");
            }
            else if (dailyAmount < 0){                                      //Printing the daily amount for loss
                lossDays++;
                System.out.println("Day "+ i + ": The amount lost is $" + Math.abs(dailyAmount));
            }
        }
        System.out.println("In this month I have won for " + winDays +" days, lost for " + lossDays + " days and drew for " + drawDays + " days");
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Gambling Simulator Program");
        GamblingSimulator simulation = new GamblingSimulator();                  //Creating a new object
        simulation.monthlyWinOrLose();                                            //Calling the method (UC5)
    }
}