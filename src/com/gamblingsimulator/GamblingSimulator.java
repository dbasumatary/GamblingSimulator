package com.gamblingsimulator;
/*Print total amount won or lost in 20 days*/
public class GamblingSimulator {
    public static final int EveryDayStake = 100;
    public static final int betEveryGame = 1;
    public void gamblingTwentyDays(){
        double upperMargin = 0.5 * EveryDayStake;                // There is 50% margin after win or lose
        double lowerMargin = -0.5 * EveryDayStake;
        double finalAmount = 0;
        for (int i = 0; i < 20; i++){                                // The gambler plays for 20 days
            double dailyAmount = 0;
            int betPlayed = 0;                             //Start initial with 0 and then to 100 bets
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
            finalAmount += dailyAmount;                               //Storing the final amount everytime in the loop
        }
        if (finalAmount > 0){
            System.out.println("The total amount won in 20 days is $"+ finalAmount);
        }
        else if (finalAmount == 0){
            System.out.println("There is no net gain in last 20 days");
        }
        else if (finalAmount < 0){
            System.out.println("The total amount lost in last 20 days is $"+ Math.abs(finalAmount));
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Gambling Simulator Program");
        GamblingSimulator simulation = new GamblingSimulator();                  //Creating a new object
        simulation.gamblingTwentyDays();                                            //Calling the method (UC4)
    }
}