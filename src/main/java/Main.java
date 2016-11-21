import java.io.Console;

/**
 * Created by voluseno85 on 09/11/2016.
 */
public class Main {
    public static void main (String [] args){
        Contact p1 = new Contact("Claudio", "Cla", 30);
        Contact p2 = new Contact("Maria", "MA", 54);
        AddressBook book = new AddressBook();

        book.add(p1);
        book.add(p2);

        //new Menu(book).run();
        try {
            new Terminal(book).run();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
