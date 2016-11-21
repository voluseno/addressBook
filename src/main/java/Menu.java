import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by voluseno85 on 10/11/2016.
 */
public class Menu {
    Scanner sc = new Scanner(System.in);
    AddressBook book;

    public Menu(AddressBook book){
        this.book = book;
    }

    public void run() {
        int option;
        selector:
            while (true) {
                System.out.println("\nSelect an option: ");
                System.out.print("1]: Add\n" +
                        "2]: Remove\n" +
                        "3]: Search\n" +
                        "4]: Print List\n" +
                        "5]: Save list\n" +
                        "6]: Open list\n" +
                        "7]: End\n" +
                        ">> ");

                option = sc.nextInt();
                switch (option) {
                    case 1:
                        add();
                        break;
                    case 2:
                        remove();
                        break;
                    case 3:
                        search();
                        break;
                    case 4:
                        System.out.print(book);
                        break;
                    case 5:
                        book.saveList();
                        break;
                    case 6:
                        book.openList();
                        break;
                    case 7:
                        break selector;
                }
            }
            System.out.println("Programma terminato.");
    }

    private void add(){
        System.out.print("\nInserire il nome: ");
        String name = sc.next();
        System.out.print("\nInserire il cognome: ");
        String surname = sc.next();
        System.out.print("\nInserire l'eta': ");
        int age = sc.nextInt();

        book.add(new Contact(name, surname, age));
    }

    private void remove(){
        System.out.print("\nInserire il nome del contatto da rimuovere: ");
        String name = sc.next();
        Contact c = book.searchByName(name);
        book.remove(c);
    }


    /**
     * Ricerca in una lista di Contact un nome e lo stampa
     * in caso di esito positivo
     */
    private void search() {
        String name;
        String op;

        search:
        while(true) {
            System.out.print("\nInserire il nome o il cognome di chi vuoi cercare: ");
            name = sc.next();

            Contact c = book.searchByName(name);

            if (c == null) {
                System.out.println("\n> Nessun elemento corrispondente al criterio di ricerca \"" + name + "\".");
            }
            else {
                System.out.println(c);
            }

            System.out.print("\nRicerca terminata. Cosa vuoi fare?");

            options:
            while(true){
                System.out.print("\nr]: fai una nuova ricerca\ne]: tornare al menu principale\n>> ");
                op = sc.next();
                switch(op) {
                    case "e":
                        break search;
                    case "r":
                        break options;
                    default:
                        System.out.println("\nOpzione non valida");
                        continue options;
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
