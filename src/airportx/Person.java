package airportx;

import java.util.ArrayList;
import java.util.Calendar;


public abstract class Person implements PersonInterface{
    
    protected int id;         //6 digit
    private String name;   
    private String surname;
    private String bday;    //dd.mm.yyyy
    private String from;

    public Person(int id, String name, String surname, String from) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.from = from;
        this.bday = DataGen.randomBday();
    }
 //public abstract int getID();
    
    public int getAge(){
        return Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(bday.substring(6));
    
    }
    
    @Override
    public String toString() {
        return "\n\nID : " + getID() + "\n\nName : " + name + "\n\nSurname : " + surname + "\n\nBirthday : " + bday + "\n\nFrom : " + from + "\n\n";
    }
    

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBday() {
        return bday;
    }

    public String getFrom() {
        return from;
    }
    
    public static int indexOf(ArrayList<Person> list,int id){
    
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id==id) {
                return i;
            }
        }
        return -1;
    }
    
    
    
    
    
    
    
}
