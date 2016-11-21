package com.clod.addressbook;

/**
 * Created by Lake on 21/11/2016.
 */
public class State {
    private AddressBook book = new AddressBook();

    public AddressBook getBook() {
        return book;
    }
    public void setBook(AddressBook book) {
        this.book = book;
    }
}
