package com.clod.addressbook.command;

import com.clod.addressbook.State;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Lake on 21/11/2016.
 */
public class SAVE implements Command {
    private String fileName;

    @Override
    public void parseArgs(String[] args) {
        fileName = args[1];
    }

    /**
     * Check if is there an existing file with the given name
     * @return
     */
     boolean checkFile(){
        //String path = "/build/classes/main/com/clod/addressbook/";
         if(new File(fileName + ".json").exists()){
            //System.out.println("EXIST");
            return true;
        }
        else{
            //System.out.println("DON'T EXIST");
            return false;
        }
    }

    /**
     * Manage the operetions of save a file
     * @param state the actual AddressBook
     */
    private void fileSaver(State state){
        Gson gson = new Gson();
        try (FileWriter fw = new FileWriter(fileName + ".json")) {
            gson.toJson(state.getBook(), fw);
            System.out.println("Book saved to " + fileName + ".json");
        } catch (IOException e) {
            System.err.println("Unable to save the book.");
        }
    }

    @Override
    public void run(State state) {
        Scanner sc = new Scanner(System.in);

            boolean check = checkFile();
            if (check){
                System.err.println("File alredy exists. \nOverwrite " + fileName + "?(yes/no): ");
                String answer = sc.next();

                switch (answer) {
                    case "yes":
                        fileSaver(state);
                        break;
                    case "no":
                        break;
                    default:
                        System.err.println("Invalid input");
                        break;
                }
            }
            else{
                    fileSaver(state);
                }
    }
}
