package storageOfPersonalData;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBookImpl();

    @Test
    public void testAddUser() {
        try {
            phoneBook.addUser("Igor", 12345, LocalDate.now());
        } catch (Exception e) {
            fail("Failed to create user");
        }
    }

    @Test
    public void testGetNumberByName() {
        phoneBook.addUser("Petr", 345, LocalDate.now());
        assertEquals(345, phoneBook.getNumberByName("Petr"));
    }

    @Test
    public void testGetNameByNumber() {
        phoneBook.addUser("Petr", 345, LocalDate.now());
        assertEquals("Petr", phoneBook.getNameByNumber(345));
    }

    @Test
    public void testStoreToFile() {
        try {
            phoneBook.storeToFile(new File("src/storageOfPersonalData/phonebook.txt"));
        } catch (Exception e) {
            fail("Failed to write to file");
        }
    }

    @Test
    public void testLoadFromFile() {
        try {
            phoneBook.loadFromFile(new File("src/storageOfPersonalData/phonebook.txt"));
        } catch (Exception e) {
            fail("Unable to read file content");
        }
    }

}
