package com.clod.addressbook.command;

import com.clod.addressbook.State;

/**
 * Created by voluseno on 19/11/2016.
 */
public interface Command {
    void parseArgs(String[] args);
    void run(State state);
}
