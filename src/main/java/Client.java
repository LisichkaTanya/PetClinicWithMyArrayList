import java.io.Serializable;

/**
 * This class includes variables Person, Pet and card number in Pet clinic
 * here are methods get, set, toString
 */
public class Client implements Serializable {
    private Person person;
    private Pet pet;
    private int cardNumber;


    public Client (int cardNumber, Person person, Pet pet) {
        this.person = person;
        this.pet = pet;
        this.cardNumber = cardNumber;
    }

    public Client(){}

    public Person getPerson() {
        return person;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCardNumber(){
        return cardNumber;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card number: " + getCardNumber() + ". " +
                "Client's name is " + person +
                ". Pet: " + pet;
    }
}
