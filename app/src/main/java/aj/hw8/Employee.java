package aj.hw8;

public class Employee {

    int ID;
    String name, titleID;

    public Employee(int ID, String name, String titleID){
        this.ID = ID;
        this.name = name;
        this.titleID = titleID;
    }

    public int GetterID() {
        return ID;
    }
    public String GetterName() {
        return name;
    }
    public String GetterTitleID() {
        return titleID;
    }

}
