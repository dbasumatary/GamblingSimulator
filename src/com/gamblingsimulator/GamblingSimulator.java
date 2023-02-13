package com.gamblingsimulator;
import java.util.Scanner;
/*Decide whether to continue or stop playing*/
public class GamblingSimulator {
    public static final int EveryDayStake = 100;
    public static final int betEveryGame = 1;
    public void continueOrStop(){
        double upperMargin = 0.5 * EveryDayStake;                 // There is 50% margin after win or lose
        double lowerMargin = -0.5 * EveryDayStake;
        double totalAmount = 0;
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
            totalAmount += dailyAmount;
        }
        /* After win whether he should play or not*/
        if (totalAmount > 0){
            System.out.println("The gambler has won $"+ totalAmount+ " last month");
            Scanner scanner = new Scanner(System.in);
            //int choice = scanner.nextInt();
            System.out.println("Would you like to keep playing? Press 1 or 2");
            System.out.println("1. Continue playing\n2. Stop playing");
            int choice = scanner.nextInt();
            if (choice == 1){                                                 // He should play further
                System.out.println("The gambler has won $"+ totalAmount+ " last month and he should continue to play in this month");
            }
            else if (choice == 2){                                               // He should not play further
                System.out.println("The gambler has won $"+ totalAmount+ " last month and he should stop gambling this month.");
            }
            else{
                System.err.println("Please enter only 1 or 2");
            }
        }
        /* If he has lost in last month*/
        else if (totalAmount <= 0){
            System.out.println("The gambler has lost $" + Math.abs(totalAmount)+ " last month and to avoid further losses he should stop playing now.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Gambling Simulator Program");
        GamblingSimulator simulation = new GamblingSimulator();                     //Creating a new object
        simulation.continueOrStop();                                            //Calling the method (UC7)
    }
}