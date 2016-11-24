package com.clod.addressbook;

import java.util.ArrayList;

/**
 * Created by Lake on 13/11/2016.
 */
public class AddressBook {
    private ArrayList<Contact> list = new ArrayList<>();

    /**
     * Adds a contact to the book
     * @param c
     */
    public void add(Contact c){
        list.add(c);
    }

    public void remove(Contact c){
        list.remove(c);
    }

    /**
     * Search for a contact by name.
     * @param name the name to search.
     * @return the contact or null
     */
    public Contact searchByName(String name){
        for(Contact c : list){
            if(name.equalsIgnoreCase(c.getName()) || name.equalsIgnoreCase(c.getSurname())){
                return c;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            builder.append(" " + (i+1) + ": " +  list.get(i).getSurname() + " " + list.get(i).getName() + "\n");
        }

        return builder.toString();
    }
}
