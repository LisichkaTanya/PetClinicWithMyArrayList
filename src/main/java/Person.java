import java.io.Serializable;

/**
 * This class includes variable  string name
 * here are methods get, set, toString
 */
public class Person implements Serializable {
    private String fullName;

    public Person(String fullName){
        this.fullName = fullName;
    }

    public Person () {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return '\'' + fullName + '\'';
    }
}
