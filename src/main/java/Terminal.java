import java.util.Scanner;
import java.lang.reflect.*;

/**
 * Created by voluseno85 on 17/11/2016.
 */
public class Terminal {
    private final AddressBook book;
    Scanner sc = new Scanner(System.in);

    Class classe;

    public Terminal(AddressBook book) throws ClassNotFoundException {
        this.book = book;
    }

    public void run(){

        String method = sc.next();
        try {
            classe = Class.forName(method);

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
