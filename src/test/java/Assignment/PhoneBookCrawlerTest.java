package Assignment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No phone number found");

        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Aman");
    }

    @Test
    public void findPhoneNumberByName_AndFindSomething(){
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Sachin");

        assertThat(phoneNumber).isEqualTo("9797979797");
    }

    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBook = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Aman");

        assertThat(phoneBook).isEqualTo("PhoneBook{phoneBookEntries={Ashish=9797979799, Sam=9797979798, Sachin=9797979797}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByName() {
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Ashish", "9797979799");

        assertThat(phoneNumber).isEqualTo("9797979799");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Aman", "9797979797");

        assertThat(name).isEqualTo("Sachin");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_nothingFoundReturnsSachinPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Aman", "9797979799");

        assertThat(name).isEqualTo("Ashish");
    }
}