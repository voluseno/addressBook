import java.util.Scanner;
import java.lang.reflect.*;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * Created by voluseno85 on 17/11/2016.
 */
public class Terminal {
    private final AddressBook book;
    Scanner sc = new Scanner(System.in);


    public Terminal(AddressBook book) throws ClassNotFoundException {
        this.book = book;
    }

    public void run(){

        String name = sc.nextLine();
        try {
            Class classe = Class.forName(name);

            Command c = (Command)classe.newInstance();
            c.run();


        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
