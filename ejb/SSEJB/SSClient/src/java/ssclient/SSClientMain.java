/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssclient;

import ejb.AccountBeanRemote;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import java.io.BufferedReader;


public class SSClientMain {
    @EJB
    private static AccountBeanRemote AccountBean;

    public SSClientMain() {
    }

    public static void main(String[] args) {
        SSClientMain main = new SSClientMain();
        //main.test();
        main.startInf();
    }

    private void startInf() {
        try {
            String choice = "";
            while (!choice.equals("0")) {
                System.out.println("\n--------------------------------------------");
                System.out.println("\tWelcome to Smart, Administrator");
                System.out.println("--------------------------------------------");
                System.out.println("\n1. Add a Staff Account");
                System.out.println("2. Delete a Staff Account");
                System.out.println("0.  Exit");

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in));
                System.out.print("\nEnter choice: ");

                choice = br.readLine();
                if (!((choice.equals("0")) || (choice.equals("1")) || (choice.equals("2")))) {
                    System.out.println("Invalid choice...Please enter only number from 0-2.");
                } else {
                    int choiceInt = Integer.valueOf(choice);
                    switch (choiceInt) {
                        case 1:
                            displayAddStaff();
                            break;
                        case 2:
                            displayDeleteStaff();
                            break;
                        case 0:
                            System.out.println();
                            System.out.println("-----------GOODBYE-ADMINISTRATOR------------\n");
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Caught an unexpected exception!");
            ex.printStackTrace();
        }
    }

    //case 1
    private void displayAddStaff() {
        String staffID;
        String name;
        String password;
        String email;
        try {
            System.out.println("\n\n\t\tAdd a Staff ID");
            staffID = getString("Staff ID", null);
            name = getString("Staff Name", null);
            password = getString("Default Password", null);
            email = getString("Staff Email", null);

            //call the manager to add student and receive result
            int result = AccountBean.addStaff(staffID, name, password, email);
            switch (result) {
                case -1:
                    System.out.println("\nError! Duplicate Staff Found!\n");
                    break;
                case 1:
                    System.out.println("\nStaff added successfully.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //case 2
    private void displayDeleteStaff() {
        String staffID;
        try {
            System.out.println("\n\n\t\tDelete a Staff Account");
            List<String> staffList = AccountBean.listStaff();
            System.out.println("List of All Staff ID: ");
            for (String string : staffList) {
                System.out.println(string);
            }
            System.out.println("\n---End of Staff List---");

            staffID = getString("Staff ID to be Deleted", null);
            int result = AccountBean.removeStaff(staffID);
            if (result == -1) {
                System.out.println("\nError! Staff Not Found!");
            } else {
                System.out.println("\nStaff deleted successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Helper Function - Accept String (not null value)
    private String getString(String attrName, String oldValue) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String stringValue = null;

        try {
            while (true) {
                System.out.print("Enter " + attrName
                        + (oldValue == null ? "" : "(" + oldValue
                                + ")") + " : ");
                stringValue = br.readLine();
                if (stringValue.length() != 0) {
                    break;
                } else if (stringValue.length() == 0
                        && oldValue != null) {
                    stringValue = oldValue;
                    break;
                }
                System.out.println("Invalid " + attrName + "...");
            }
        } catch (Exception ex) {
            System.out.println("\nSystem Error Message: "
                    + ex.getMessage() + "\n");
        }
        return stringValue.trim();
    }    
}
