package com.qa.barrenmoore;

public class App 
{
    // grid 3 by 3
    private int x =2;
    private int y =2;

    public static void main( String[] args )
    {
        boolean exit = false;
        while (!exit){
            System.out.println("Actions available: location, check, east, west, north, south");
            System.out.println("Please type what would you like to do:");
            String userInput = System.console().readLine();
        }
    }

    private void printLocation(){
        System.out.println("You are at x:" + x + ", y:" + y);
    }
}
