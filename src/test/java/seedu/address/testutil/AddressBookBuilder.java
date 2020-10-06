package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.deck.entry.Entry;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withEntry("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Entry} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withEntry(Entry entry) {
        addressBook.addEntry(entry);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
