package com.clod.addressbook.command;

import com.clod.addressbook.Contact;
import com.clod.addressbook.State;

/**
 * Created by Lake on 21/11/2016.
 */
public class REMOVE implements Command{
    private String name;

    @Override
    public void parseArgs(String[] args) {
        name = args[1];
    }

    @Override
    public void run(State state) {
        Contact c = state.getBook().searchByName(name);
        if(c == null){
            System.err.println("Contact not found");
        }
        else {
            state.getBook().remove(c);
            System.out.println("contact removed");
        }
    }
}
