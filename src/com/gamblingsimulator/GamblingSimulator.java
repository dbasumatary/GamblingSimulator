package com.gamblingsimulator;
/*Print the luckiest and unluckiest day and by how much*/
public class GamblingSimulator {
    public static final int EveryDayStake = 100;
    public static final int betEveryGame = 1;
    public void luckiestOrUnluckiest(){
        double upperMargin = 0.5 * EveryDayStake;                 // There is 50% margin after win or lose
        double lowerMargin = -0.5 * EveryDayStake;
        int luckyDay = 0, unluckyDay = 0;                         //Instantiate new variables
        double luckyDayAmount = 0, unluckyDayAmount = 0;
        for (int i = 1; i < 31; i++){                                // The gambler plays for a month
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
            if (luckyDayAmount < dailyAmount){                         //Checking the condition for lucky days
                luckyDayAmount = dailyAmount;
                luckyDay = i;
            }
            else if (unluckyDayAmount > dailyAmount){                  //Checking the condition for unlucky days
                unluckyDayAmount = dailyAmount;
                unluckyDay = i;
            }
        }
        System.out.println("The luckiest day for the gambler is day " + luckyDay + " of the month. He won $" + luckyDayAmount);
        System.out.println("The unluckiest day for the gambler is day " + unluckyDay + " of the month. He lost $" + Math.abs(unluckyDayAmount));
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Gambling Simulator Program");
        GamblingSimulator simulation = new GamblingSimulator();                     //Creating a new object
        simulation.luckiestOrUnluckiest();                                            //Calling the method (UC6)
    }
}