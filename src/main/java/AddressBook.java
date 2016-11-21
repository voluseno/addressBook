import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;
//import com.google.gson.Gson;

/**
 * Created by Lake on 13/11/2016.
 */
public class AddressBook implements Command{
    private ArrayList<Contact> list = new ArrayList<>();
    Gson gson = new Gson();
    String json;


    public void run(){
        System.out.println("AddressBook.run()");
    }

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
            if(name.equalsIgnoreCase(c.getName())){
                return c;
            }
        }
        return null;
    }

    public void saveList(){
        String json = gson.toJson(list);
        System.out.println(json);
    }

    public void openList(){
        Type collecType = new TypeToken<ArrayList<Contact>>(){}.getType();
        //ArrayList<Contact> list2 = gson.fromJson(json, collecType);
        list = gson.fromJson(json, collecType);
        //list = list2;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            builder.append(" " + (i+1) + ": " +  list.get(i).getSurname() + " " + list.get(i).getName() + "\n");
        }

        return builder.toString();
    }
}
