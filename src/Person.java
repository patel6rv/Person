import java.util.Calendar;

public class Person
{
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    static private int IDSeed = 1;

    public Person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String title, int YOB) {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }

    public String getIDNum() {
        return IDNum;
    }

    private String genIDNum() {
        String newID = "" + IDSeed;
        while(newID.length() < 8){
            newID = "0" + newID;
        }
        IDSeed++;

        return newID;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + firstName + " " + lastName;
    }

    Calendar calendar = Calendar.getInstance();

    public int getAge() {
        int age = calendar.get(Calendar.YEAR) - getYOB();
        return age;
    }

    public int getAge(int year) {
        int age = year - getYOB();
        return age;
    }

    public String toCSVRecord() {
        return IDNum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }
}
