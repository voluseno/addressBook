package com.clod.addressbook.command;

import com.clod.addressbook.AddressBook;
import com.clod.addressbook.State;
import com.google.gson.Gson;

import java.io.FileReader;

/**
 * Created by Lake on 21/11/2016.
 */
public class OPEN implements Command {
    private String fileName;

    @Override
    public void parseArgs(String[] args) {
        fileName = args[1];
    }

    @Override
    public void run(State state) {
        Gson gson = new Gson();
        try(FileReader fr = new FileReader(fileName)) {
            AddressBook ab = gson.fromJson(fr, AddressBook.class);
            state.setBook(ab);
        } catch (java.io.IOException e) {
            System.err.println("File not found: " + fileName);
        }
    }
}
