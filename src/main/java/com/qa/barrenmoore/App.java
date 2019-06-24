package com.qa.barrenmoore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class App
{
    // grid 3 by 3
    private static int x = Constants.two;
    private static int y = Constants.two;

    private static int treasureX;
    private static int treasureY;

    private static boolean exit = false;

    public static void main( String[] args ) throws IOException
    {
        placeTreasure();
        while (!exit){
            initialMessages();
            dealWithUserInput();
        }
    }

    private static void dealWithUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        checkUserInput(reader.readLine().toLowerCase());
    }

    private static void initialMessages(){
        System.out.println(Constants.actionsMessage);
        System.out.println(Constants.userActionPromptMessage);
    }

    private static void checkUserInput(String userInput){
        switch (userInput) {
            case Constants.location:
                printLocation();
                break;
            case Constants.exit:
                exit = true;
                break;
            case Constants.check:
                checkForTreasure();
                break;
            case Constants.compass:
                System.out.println(Constants.youAreMessage + distanceFromTreasure() + Constants.tilesAwayMessage);
                break;
            case Constants.north:
                if (x - Constants.one > Constants.zero) {
                    x -= Constants.one;
                }
                break;
            case Constants.south:
                if (x + Constants.one <= Constants.three) {
                    x += Constants.one;
                }
                break;
            case Constants.east:
                if (y + Constants.one <= Constants.three) {
                    y += Constants.one;
                }
                break;
            case Constants.west:
                if (y - Constants.one > Constants.zero) {
                    y -= Constants.one;
                }
                break;
            default:
                System.out.println(Constants.invalidCommandMessage);
        }
    }

    private static void printLocation(){
        System.out.println(Constants.youAreAtMessage + x + Constants.yMessage + y);
    }

    private static void placeTreasure(){
        Random r = new Random();
        treasureX = r.nextInt(Constants.four);
        treasureY = r.nextInt(Constants.four);
    }

    private static int distanceFromTreasure(){
        return Math.abs(((treasureX - x) + (treasureY -y)));
    }

    private static void checkForTreasure(){
        if (x == treasureX & y == treasureY){
            System.out.println(Constants.treasureFoundMessage);
            exit = true;
        } else {
            System.out.println(Constants.nothinFoundMessage);
        }
    }

}
