package com.qa.barrenmoore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    // grid 3 by 3
    private static int x =2;
    private static int y =2;

    public static void main( String[] args ) throws IOException
    {
        boolean exit = false;
        while (!exit){
            System.out.println("Actions available: location, check, east, west, north, south, exit");
            System.out.println("Please type what would you like to do:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = reader.readLine();
            if(userInput.toLowerCase().equals("location")){
                printLocation();
            } else if (userInput.toLowerCase().equals("exit")){
                exit = true;
            }
        }
    }

    private static void printLocation(){
        System.out.println("You are at x:" + x + ", y:" + y);
    }
}
