package com.clod.addressbook.command;

import com.clod.addressbook.State;

/**
 * Created by Lake on 21/11/2016.
 */
public class PRINT implements Command {
    @Override
    public void parseArgs(String[] args) {

    }

    @Override
    public void run(State state) {
        System.out.println(state.getBook());
    }
}
