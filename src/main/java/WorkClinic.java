import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LisichkaTanya
 * @since 18.04.2020
 * This class include method main, point of enter program, read from file on start and write in file on the end program
 */
public class WorkClinic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PetClinic2 petClinic2 = new PetClinic2();
        try {
            petClinic2 = readFromFile();
        }
        catch (Exception e){
            System.out.println("Pet Clinic is empty  " + e);
        }


        String exitFromClinic = "no";
        while (exitFromClinic.equals("no")) {
            System.out.println("Choose the operation. Enter the appropriate number: \n" +
                    "1 - add new client \n" +
                    "2 - find a client by full name \n" +
                    "3 - find a client by pet name \n" +
                    "4 - find a client by card number \n" +
                    "5 - delete a client \n" +
                    "6 - rename a client \n" +
                    "7 - rename a pet \n" +
                    "8 - view all clients\n" +
                    "9 - exit the clinic");

            int operation = Integer.parseInt(reader.readLine());

            switch (operation) {
                case 1: petClinic2.addNewClient( readFromScreen("Enter full name of client:"),
                                                readFromScreen("Enter type of pet:"),
                                                readFromScreen("Enter  pet name:"));
                    break;
                case 2: petClinic2.findClientByName(readFromScreen("Enter the name you are looking for:"));
                    break;
                case 3: petClinic2.findClientByPetName(readFromScreen("Enter the pet name you are looking for:"));
                    break;
                case 4: petClinic2.findClientByCardNumber(readFromScreen("Enter the card number you are looking for:"));
                    break;
                case 5: petClinic2.deleteClient(readFromScreen("Enter name of client which you want to delete:"));
                    break;
                case 6 : petClinic2.renameClient(readFromScreen("Enter the name you are looking for rename:"),
                                                readFromScreen("Enter new name for client:"));
                    break;
                case 7 : petClinic2.renamePet(readFromScreen("Enter the pet name you are looking for rename:"),
                                             readFromScreen("Enter new pet name:"));
                    break;
                case 8: petClinic2.viewAllClients();
                    break;
                case 9: exitFromClinic = "yes";
                    writeInFile(petClinic2);
                    break;
                case 10: writeInFile(petClinic2);
                    break;
                case 11: readFromFile();
                    break;
            }
        }
    }

    /**
     * This method to communicate via the screen
     * @param input - String which tell to user what he need to do
     * @return - will return string what was reading from screen
     */
    public static String readFromScreen (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        String read = scanner.nextLine();
        return read;
    }

//    /**
//     * 9 case: Write object PetClinic with registration list in file before exit
//     */
//    public static void writeInFileJson (PetClinic2 petClinic2) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String result = objectMapper.writeValueAsString(petClinic2);
////        System.out.println(result);
//        PrintWriter printWriter = new PrintWriter(new File("RegistrationClientsOfPetClinic2.bin"));
//        printWriter.println(result);
//        printWriter.close();
//    }
//
//    /**
//     *  Read object PetClinic with registration list from file on start program
//     * @return object PetClinic with list with all clients previously entered
//     */
//    public static PetClinic2 readFromFileJson () throws IOException {
//        PetClinic2 petClinic2;
//        Scanner scanner = new Scanner(new File("RegistrationClientsOfPetClinic2.bin"));
//        String result = scanner.nextLine();
//        ObjectMapper objectMapper = new ObjectMapper();
//        petClinic2 = objectMapper.readValue(result, PetClinic2.class);
//        scanner.close();
//        return petClinic2;
//    }


    /**
     //     *  This method write object with registration list in file
     //     *  @return object with list with all clients previously entered
     //    */

    public static void writeInFile (PetClinic2 petClinic2) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("RegistrationClientsOfPetClinic2.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(petClinic2);
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *  Read registration list from file on start program
     */
    public static PetClinic2 readFromFile () throws IOException {
        PetClinic2 petClinic2 = new PetClinic2();
        try {
            FileInputStream fis = new FileInputStream("RegistrationClientsOfPetClinic2.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            petClinic2 = (PetClinic2) ois.readObject();
            ois.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return petClinic2;
    }
}