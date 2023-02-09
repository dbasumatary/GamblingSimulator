package com.gamblingsimulator;
/*Making a bet with $1 and observing the outcome*/
public class GamblingSimulator {
    public static final int EveryDayStake = 100;                    //Initializing static variable (UC1)
    public static final int betEveryGame = 1;                       //Initializing static variable (UC1)
    /*Creating a new method to see if gambler won or lost (UC2)*/
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
    public static void main(String[] args) {
        System.out.println("Welcome To Gambling Simulator Program");
        GamblingSimulator simulationUC2 = new GamblingSimulator();                 //Creating a new object
        simulationUC2.gamblingWinLose();                                           //Calling the method
    }
}