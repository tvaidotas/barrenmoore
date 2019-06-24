package com.qa.barrenmoore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class App
{

    private static Coordinate grid;

    private static Coordinate treasure;

    private static boolean exit = false;

    public static void main( String[] args ) throws IOException
    {
        placeTreasure();
        initializeGrid();
        while (!exit){
            initialMessages();
            dealWithUserInput();
        }
    }

    private static void initializeGrid(){
        grid = new Coordinate(Constants.two, Constants.two);
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
                if (grid.getX() - Constants.one > Constants.zero) {
                    grid.setX(grid.getX() - Constants.one);
                }
                break;
            case Constants.south:
                if (grid.getX() + Constants.one <= Constants.three) {
                    grid.setX(grid.getX() + Constants.one);
                }
                break;
            case Constants.east:
                if (grid.getY() + Constants.one <= Constants.three) {
                    grid.setY(grid.getY() + Constants.one);
                }
                break;
            case Constants.west:
                if (grid.getY() - Constants.one > Constants.zero) {
                    grid.setY(grid.getY() - Constants.one);
                }
                break;
            default:
                System.out.println(Constants.invalidCommandMessage);
        }
    }

    private static void printLocation(){
        System.out.println(Constants.youAreAtMessage + grid.getX() + Constants.yMessage + grid.getY());
    }

    private static void placeTreasure(){
        Random r = new Random();
        treasure = new Coordinate(r.nextInt(Constants.four), r.nextInt(Constants.four));
    }

    private static int distanceFromTreasure(){
        return Math.abs(((treasure.getX() - grid.getY()) + (treasure.getY() - grid.getY())));
    }

    private static void checkForTreasure(){
        if (grid.getX() == treasure.getX() & grid.getY() == treasure.getY()){
            System.out.println(Constants.treasureFoundMessage);
            exit = true;
        } else {
            System.out.println(Constants.nothinFoundMessage);
        }
    }

}
