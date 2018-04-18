package aj.hw8;

public class Employee {


    String ID, name, titleID;

    public Employee(String ID, String name, String titleID){
        this.ID = ID;
        this.name = name;
        this.titleID = titleID;
    }

    public Employee(){

    }

    public String GetterID() {
        return ID;
    }
    public String GetterName() {
        return name;
    }
    public String GetterTitleID() {
        return titleID;
    }
    public void SetterID(String id) {
        this.ID = id;
    }
    public void SetterLast(String last) {
        this.name = last;
    }
    public void SetterTitleID(String title) {
        this.titleID = title;
    }

}
