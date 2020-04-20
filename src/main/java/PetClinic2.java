import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

/**
 * This class include array  which collects persons and their pets and give the new client a card number
 * here implemented all methods (add new client, find, rename client or his pet, delete client from list, view all list)
 */
@JsonAutoDetect
public class PetClinic2 implements Serializable {
    MyArrayList<Client> arrayPetsClinicRegistration = new MyArrayList<Client>();
    private Object Client;

//    /**
//     * This method to communicate via the screen
//     * @param input - String which tell to user what he need to do
//     * @return - will return string what was reading from screen
//     */
//    public static String readFromScreen (String input) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(input);
//        String read = scanner.nextLine();
//        return read;
//    }

    // 1 case:
    public void addNewClient (String personName, String petType, String petName){
        int cardNumber = arrayPetsClinicRegistration.size() + 1;
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++){
            if (arrayPetsClinicRegistration.get(i).getCardNumber() >= arrayPetsClinicRegistration.size()){
                cardNumber = arrayPetsClinicRegistration.get(i).getCardNumber() + 1;
            }
        }
        Client client = new Client (cardNumber, new Person(personName),
                new Pet(petType, petName));
        if (arrayPetsClinicRegistration.size() == 0) {
            arrayPetsClinicRegistration.add(client);
            System.out.println("Client was added. " + client);
            return;
        }
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (client.getPerson().getFullName().equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                System.out.println("This person is already in the clinic's list " + arrayPetsClinicRegistration.get(i));
                return;
            }
            else {
                arrayPetsClinicRegistration.add(client);
                System.out.println("Client was added. " + client);
                return;
            }
        }
    }

    // 2 case:
    public Client findClientByName (String findName){
        Client findClient = null;
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findName.equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                System.out.println("Find " + arrayPetsClinicRegistration.get(i));
                findClient = arrayPetsClinicRegistration.get(i);
                return findClient;
            }
        }
        System.out.println(findName + " is not found.");
        return findClient;
    }

    // 3 case:
    public Client findClientByPetName (String findPetName){
        Client findClient = null;
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findPetName.equals(arrayPetsClinicRegistration.get(i).getPet().getPetName())) {
                System.out.println("Find " + arrayPetsClinicRegistration.get(i));
                findClient = arrayPetsClinicRegistration.get(i);
                return findClient;
            }
        }
        System.out.println(findPetName + " is not found.");
        return findClient;
    }

    // 4 case:
    public Client findClientByCardNumber (String findCardNumber){
        Client findClient = null;
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (Integer.parseInt(findCardNumber) == (arrayPetsClinicRegistration.get(i).getCardNumber())) {
                System.out.println("Find " + arrayPetsClinicRegistration.get(i));
                findClient = arrayPetsClinicRegistration.get(i);
                return findClient;
            }
        }
        System.out.println(findCardNumber + " is not found.");
        return findClient;
    }

    // 5 case:
    public void deleteClient (String deleteClientByName){
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (deleteClientByName.equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                arrayPetsClinicRegistration.remove(i);
                System.out.println("Client " + deleteClientByName + " was remove from Clinic. ");
                return;
            }
        }
        System.out.println(deleteClientByName + " is not found.");
    }

    // 6 case:
    public void renameClient (String findName, String newName){
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findName.equals(arrayPetsClinicRegistration.get(i).getPerson().getFullName())) {
                System.out.println("Successful find. " + arrayPetsClinicRegistration.get(i));
                arrayPetsClinicRegistration.get(i).getPerson().setFullName(newName);
                System.out.println("Successful rename " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findName + " is not found.");
    }

    // 7 case:
    public void renamePet (String findPetName, String newPetName){
        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            if (findPetName.equals(arrayPetsClinicRegistration.get(i).getPet().getPetName())) {
                System.out.println("Successful find. " + arrayPetsClinicRegistration.get(i));
                arrayPetsClinicRegistration.get(i).getPet().setPetName(newPetName);
                System.out.println("Successful rename pet " + arrayPetsClinicRegistration.get(i));
                return;
            }
        }
        System.out.println(findPetName + " is not found.");
    }

    // 8 case:
    public void viewAllClients (){
        if (arrayPetsClinicRegistration.size()== 0){
            System.out.println("No clients in clinic");
            return;
        }

        for (int i = 0; i < arrayPetsClinicRegistration.size(); i++) {
            System.out.println(arrayPetsClinicRegistration.get(i));
        }
    }

//    @Override
//    public String toString() {
//        return "PetClinic \n" +
//                arrayPetsClinicRegistration;
//    }

    public MyArrayList<Client> getArrayPetsClinicRegistration() {
        return arrayPetsClinicRegistration;
    }
}
