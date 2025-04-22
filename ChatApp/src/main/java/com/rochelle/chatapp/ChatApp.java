/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.rochelle.chatapp;

import java.util.Scanner;

/**
 *
 * @author 27790
 */
public class ChatApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        Login user = new Login(username, password);
        System.out.println(user.registerUser());

        System.out.println("Please enter your username to login: ");
        String usernameInput = scanner.nextLine();
        System.out.println("Please enter your password to login: ");
        String passwordInput = scanner.nextLine();

        boolean loginStatus = user.loginUser(usernameInput, passwordInput);
        System.out.println(user.returnLogin(loginStatus));

        scanner.close();

    }
}
