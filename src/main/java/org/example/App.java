/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Reese Stowell
 */
package org.example;
import java.util.Scanner;

import java.util.regex.*;
public class App {
    static int passwordValidator(String input)
    {
        if(input.length()<8){
            if (input.matches("[0-9]+"))
            {
                return 1;
            }
            else if (input.matches("[a-zA-Z]+"))
            {
                return 2;
            }
        }
        String regex2 = "^(?=.*?[a-zA-Z])(?=.*?[0-9]).{8,}$";;
        String regex1 = "^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern p2 = Pattern.compile(regex2);
        Pattern p = Pattern.compile(regex1);
        Matcher m2 = p2.matcher(input);
        Matcher m = p.matcher(input);
        if (m2.find())
        {
            return 3;
        }
        if (m.find())
        {
            return 4;
        }
        return 0;
    }
    public static void main(String[] args) {

        Scanner user_input = new Scanner(System.in);
        String password, password_strength = null;

        System.out.print("Enter your password ");
        password = user_input.nextLine();

        switch (passwordValidator(password))
        {
            case 1: password_strength = ("very weak");
            break;
            case 2: password_strength = ("weak");
            break;
            case 3: password_strength = ("strong");
            break;
            case 4: password_strength = ("very strong");
            break;
        }
        System.out.println(String.format("The password " + password + " is a %s password", password_strength));
    }
}
