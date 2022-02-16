package Assignment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PhoneBook phoneBook = new PhoneBook();

    @Test
    public void findPhoneNumberByName() {
        String sachin = "Sachin";

        Optional<String> phoneNumber = phoneBook.findPhoneNumberByName(sachin);

        assertThat(phoneNumber.get()).isEqualTo("9797979797");
    }

    @Test
    public void findPhoneNumberByName_NotFound() {
        expectedException.expect(NoSuchElementException.class);

        String sachin1 = "Sachin Kumar";
        Optional<String> phoneNumber = phoneBook.findPhoneNumberByName(sachin1);

        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber() {
        Optional<String> name = phoneBook.findNameByPhoneNumber("9797979797");

        assertThat(name.get()).isEqualTo("Sachin");
    }

    @Test
    public void findNameByPhoneNumber_NotFound() {
        expectedException.expect(NoSuchElementException.class);

        Optional<String> phoneNumber = phoneBook.findPhoneNumberByName("9797979799");

        phoneNumber.get();
    }
}