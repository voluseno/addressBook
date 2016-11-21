/**
 * Created by voluseno85 on 09/11/2016.
 */
public class Contact {
    private String name;
    private String surname;
    private int age;

    public Contact(String name, String surname, int age){
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Name: " + this.name + "\nSurname: " + this.surname +
                "\nAge: " + this.age;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public int getAge(){
        return this.age;
    }

   public Contact getPerson(){
       return this;
   }
}
