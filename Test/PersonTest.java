import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest
{

    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Person("00000A", "Bob", "Rob", "Tester1", 1955);
        p2 = new Person("00000B", "Sally", "Vally", "Tester2", 1975);
        Person.setIDSeed(0);
        p3 = new Person("Bob", "Rob", "Tester3",1960);
        p4 = new Person("Sally", "Vally", "Tester4",1965);
        p5 = new Person("Fred", "Bred", "Tester5",1970);
        p6 = new Person("Cindy", "Mindy", "Tester6",1975);

    }

    @Test
    void getIDSeed() {
        assertEquals(4, Person.getIDSeed());
    }

    @Test
    void setIDSeed() {
    }

    @Test
    void getIDNum() {
        assertEquals("00000A", p1.getIDNum());
    }

    @Test
    void setIDNum() {
        p1.setIDNum("00000B");
        assertEquals("00000B", p1.getIDNum());
    }

    @Test
    void getFirstName() {
        assertEquals("Bob", p1.getFirstName());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Dylan");
        assertEquals("Dylan", p1.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Rob", p1.getLastName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Bor");
        assertEquals("Bor", p1.getLastName());
    }

    @Test
    void getTitle() {
        assertEquals("Tester1", p1.getTitle());
    }

    @Test
    void setTitle() {
        p1.setTitle("Tester2");
        assertEquals("Tester2", p1.getTitle());
    }

    @Test
    void getYOB() {
        assertEquals(1955, p1.getYOB());
    }

    @Test
    void setYOB() {
        p1.setYOB(2000);
        assertEquals(2000, p1.getYOB());
    }

    @Test
    void testToString() {
        String expected = "Person{IDNum='" + p1.getIDNum() + "', firstName='" + p1.getFirstName() + "', lastName='" + p1.getLastName() + "', title='" + p1.getTitle() + "', YOB=" + p1.getYOB() + "}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void fullName() {
        assertEquals("Bob Rob", p1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Tester1 Bob Rob", p1.formalName());
    }

    @Test
    void getAge() {
        assertEquals(67, p1.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals(45, p1.getAge(2000));
    }
}
