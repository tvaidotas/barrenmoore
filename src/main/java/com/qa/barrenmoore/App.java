package com.qa.barrenmoore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class App
{
    // grid 3 by 3
    private static int x = 2;
    private static int y = 2;

    private static int treasureX;
    private static int treasureY;

    public static void main( String[] args ) throws IOException
    {
        boolean exit = false;
        placeTreasure();
        while (!exit){
            System.out.println("Actions available: location, check, compass, east, west, north, south, exit");
            System.out.println("Please type what would you like to do:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = reader.readLine();
            if(userInput.toLowerCase().equals("location")){
                printLocation();
            } else if (userInput.toLowerCase().equals("exit")){
                exit = true;
            } else if (userInput.toLowerCase().equals("check")){
                if (x == treasureX & y == treasureY){
                    System.out.println("Congratulations! You've found the treasure!");
                    exit = true;
                } else {
                    System.out.println("Nothing found");
                }
            } else if(userInput.toLowerCase().equals("compass")){
                System.out.println("You are "+ Math.abs(((treasureX - x) + (treasureY -y)))+ " tiles away from the treasure");
            } else if (userInput.toLowerCase().equals("north")){
                if (x - 1 > 0) {
                    x -= 1;
                }
            } else if (userInput.toLowerCase().equals("south")){
                if (x + 1 <= 3) {
                    x += 1;
                }
            } else if (userInput.toLowerCase().equals("east")){
                if (y + 1 <= 3) {
                    y += 1;
                }
            } else if (userInput.toLowerCase().equals("west")){
                if (y - 1 > 0) {
                    y -= 1;
                }
            }
        }
    }

    private static void printLocation(){
        System.out.println("You are at x:" + x + ", y:" + y);
    }

    private static void placeTreasure(){
        Random r = new Random();
        treasureX = r.nextInt(4);
        treasureY = r.nextInt(4);
    }
}
