package Assignment;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
        {
            put("Sachin", "9797979797");
            put("Sam", "9797979798");
            put("Ashish", "9797979799");
        }
    };

    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    PhoneBook() { }

    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    public Optional<String> findPhoneNumberByName(String name){
        if (phoneBookEntries.containsKey(name)){
            return Optional.of(phoneBookEntries.get(name));
        }
        return Optional.empty();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber){
        for (Map.Entry<String, String> entry : phoneBookEntries.entrySet()){
            if (entry.getValue().equals(phoneNumber)){
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneBookEntries +
                '}';
    }
}
