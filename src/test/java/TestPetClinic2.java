import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class TestPetClinic2 {
    private PetClinic2 testPetClinic2;
    @Before
    public void setUp() {
        Client client1 = new Client(1, new Person("Tatiana"), new Pet("cat", "Varya"));
        Client client2 = new Client(2, new Person("Daria"), new Pet("hamster", "Pushok"));
        Client client3 = new Client(3, new Person("Galina"), new Pet("dog", "Dusya"));
        testPetClinic2 = new PetClinic2();
        testPetClinic2.arrayPetsClinicRegistration.add(client1);
        testPetClinic2.arrayPetsClinicRegistration.add(client2);
        testPetClinic2.arrayPetsClinicRegistration.add(client3);

}

    @Test
public void shouldAddNewClient(){
        Assert.assertThat(testPetClinic2.arrayPetsClinicRegistration.size(), is (3));
        testPetClinic2.addNewClient ("Evgeny", "crocodile", "Gena");
        Assert.assertThat(testPetClinic2.arrayPetsClinicRegistration.size(), is (4));
    }

    @Test
    public void shouldFindClientByName(){
        Assert.assertThat(testPetClinic2.findClientByName("Daria"),is(testPetClinic2.arrayPetsClinicRegistration.get(1)));
    }

    @Test
    public void shouldFindClientByPetName(){
        Assert.assertThat(testPetClinic2.findClientByPetName("Dusya"),is(testPetClinic2.arrayPetsClinicRegistration.get(2)));
    }

    @Test
    public void shouldFindClientByCardNumber(){
        Assert.assertThat(testPetClinic2.findClientByCardNumber("1"),is(testPetClinic2.arrayPetsClinicRegistration.get(0)));
    }

    @Test
    public void shouldDeleteClientByName(){
        testPetClinic2.deleteClient("Daria");
        Assert.assertThat(testPetClinic2.arrayPetsClinicRegistration.size(), is(2));
    }

    @Test
    public void shouldRenameClient(){
        testPetClinic2.renameClient("Daria", "Dasha");
        Assert.assertThat(testPetClinic2.arrayPetsClinicRegistration.get(1).getPerson().getFullName(), is("Dasha"));
    }

    @Test
    public void shouldRenamePet(){
        testPetClinic2.renamePet("Varya", "Murzik");
        Assert.assertThat(testPetClinic2.arrayPetsClinicRegistration.get(0).getPet().getPetName(), is("Murzik"));
    }
}