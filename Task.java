package com.infostretch;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please Enter the folder Path: ");
        String folderPath = scan.next();

        File folder = new File(folderPath);
        boolean condition = true;

        if (folder.exists()) {

            while (condition) {

                System.out.println("========================================================");
                displayFolderContent(folderPath);
                System.out.println("========================================================");
                System.out.println();
                System.out.println("Choose an action:\n ADD \n DELETE \n SEARCH \n NOTHING");
                System.out.println();

                String action = scan.next().toUpperCase();
                String fileName = null;

                if (action.equals("ADD") || action.equals("DELETE") || action.equals("SEARCH")) {
                    System.out.println("Enter the File Name, Which you want to: " + action);
                    fileName = scan.next();
                }

                switch (action) {
                    case "ADD":
                        addFile(folderPath, fileName);
                        break;

                    case "SEARCH":
                        searchFile(folderPath, fileName);

                        break;
                    case "DELETE":
                        deleteFile(folderPath, fileName);
                        break;

                    // Default case statement
                    default:
                        System.out.println("You are moving out from the folder");
                        System.out.println("THANK YOU");
                        condition = false;

                }

            }

        } else {
            System.out.println("The Folder having path (" + folderPath + ")does not exist.");
            System.out.println("Please provide correct folder path");
        }

    }

    private static void displayFolderContent(String folderPath) {

        System.out.println("Showing Folder Content \n");
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        Arrays.sort(files);

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

    }

    private static void deleteFile(String folderPath, String fileName) {
        File file = new File(folderPath + File.separator + fileName);
        if (file.delete()) {
            System.out.println(file.getName() + " file is deleted successfully.");
        } else {
            System.out.println("Unexpected error found in deletion of the file.");
        }

    }

    private static void searchFile(String folderPath, String fileName) {
        File file = new File(folderPath + File.separator + fileName);
        if (file.exists()) {

            System.out.println("Yes File is present");
            System.out.println("The path of the file is: " + file.getAbsolutePath());
        } else {
            System.out.println("The file does not exist.");
        }
    }

    private static void addFile(String folderPath, String fileName) {
        try {
            File file = new File(folderPath + File.separator + fileName);

            if (file.createNewFile()) {
                System.out.println("File " + file.getName() + " is created successfully.");
            } else {
                System.out.println("File is already exist in the directory.");
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

}