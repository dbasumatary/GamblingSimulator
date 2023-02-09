package com.gamblingsimulator;
/*Gambler would resign for the day if won or lose 50% of stake*/
public class GamblingSimulator {
    public static final int EveryDayStake = 100;                    //Initializing static variable for total stack (UC1)
    public static final int betEveryGame = 1;                       //Initializing static variable for every bet (UC1)
    /*(UC2) Creating a new method to see if gambler won or lost*/
    public void gamblingWinLose(){
        double random = Math.random();
        int remainingAmount = EveryDayStake;         //Before the bet the remaining amount and total stake is same
        if (random > 0.5){
            remainingAmount += betEveryGame;
            System.out.println("The Gambler won the first bet. He has $" +remainingAmount+ " remaining with him.");
        }
        else{
            remainingAmount -= betEveryGame;
            System.out.println("The Gambler lost the first bet. He has $" +remainingAmount+ " remaining with him.");
        }
    }
    /*(UC3) Creating a new method to print that gambler would resign for the day if won or lose 50% of stake*/
    public void gamblerResign(int margin){
        int highAmount = EveryDayStake + margin*EveryDayStake/100;            //Upper margin for resigning
        int lowAmount = EveryDayStake - margin*EveryDayStake/100;             //Lower margin for resigning
        int availableAmount = EveryDayStake;                                   //Before the bet they will be same
        while ((availableAmount < highAmount) && (availableAmount > lowAmount)){
            double random = Math.random();
            if (random > 0.5){                                           //Using random to check if gambler win or lose
                availableAmount += betEveryGame;
            }
            else{
                availableAmount -= betEveryGame;
            }
        }
        System.out.println("The Gambler resigns for the day. He has $" +availableAmount+ " remaining with him.");
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Gambling Simulator Program");
        GamblingSimulator simulation = new GamblingSimulator();                 //Creating a new object
        simulation.gamblingWinLose();                                            //Calling the first method (UC2)
        GamblingSimulator resignCheck = new GamblingSimulator();
        resignCheck.gamblerResign(50);                                //Calling the second method (UC3)
    }
}