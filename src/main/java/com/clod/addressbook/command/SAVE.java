package com.clod.addressbook.command;

import com.clod.addressbook.State;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Lake on 21/11/2016.
 */
public class SAVE implements Command {
    @Override
    public void parseArgs(String[] args) {

    }

    @Override
    public void run(State state) {
        Gson gson = new Gson();
        try(FileWriter fw = new FileWriter("address-book.json")) {
            gson.toJson(state.getBook(), fw);
            System.out.println("Book saved.");
        } catch (IOException e) {
            System.err.println("Unable to save the book.");
        }
    }
}
