package com.clod.addressbook;

import com.clod.addressbook.command.Command;

import java.util.Scanner;

/**
 * Created by voluseno85 on 17/11/2016.
 */
public class Terminal {
    private final State state = new State();

    public void run(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine();
            String[] split = line.split(" ");
            try {
                Class clazz = Class.forName("com.clod.addressbook.command." + split[0].toUpperCase());
                Command c = (Command) clazz.newInstance();
                c.parseArgs(split);
                c.run(state);

            } catch (Exception e) {
                System.err.println("Unkown command: " + split[0]);
            }
        }
    }
}
