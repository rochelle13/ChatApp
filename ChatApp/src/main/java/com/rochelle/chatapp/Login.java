/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rochelle.chatapp;


public class Login {

    //Variables
    private String username;
    private String password;

    //Constructor
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Methods
    public boolean checkUsername() {
        if (username.length() <= 12 && username.contains("$")) {
            return true;
        } else {
            return false;
        }
    }
/*
Title: Java If...Else
Author: W3Schools
Date: 14/04/2025
Code version: (no code version)/ (N/A)
Availability:https://www.w3schools.com/java/java_conditions.asp
 */
    public boolean checkPassword() {
        final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(passwordRegex);
    }
//-------------------END OF CODE ATTRIBUTION------------------------------------
    public String registerUser() {
        if (!checkUsername()) {
            return "Username format not correct";
        } else if (!checkPassword()) {
            return "Password format not correct";
        } else {
            return "Username and password successfully captured";
        }
    }
    
    public boolean loginUser(String usernameInput, String passwordInput){
        if(usernameInput.equals(username) && passwordInput.equals(password)){
            return true;
        }else{
            return false;
        }
    }
    
    public String returnLogin(boolean loginStatus){
        if(loginStatus){
            return "Welcome Rochelle";
        }else{
            return "Invalid credentials";
        }
    }
}
