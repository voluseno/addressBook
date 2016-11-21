package com.clod.addressbook.command;

import com.clod.addressbook.AddressBook;
import com.clod.addressbook.Contact;
import com.clod.addressbook.State;

/**
 * Created by Lake on 21/11/2016.
 */
public class ADD implements Command {
    private String name, surname;
    private int age;

    @Override
    public void parseArgs(String[] args) {
        name = args[1];
        surname = args[2];
        age = Integer.parseInt(args[3]);
    }

    @Override
    public void run(State state) {
        state.getBook().add(new Contact(name, surname, age));
        System.out.println("contact added");
    }



}
