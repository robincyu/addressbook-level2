package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.*;

public class SortCommandTest {
    private AddressBook addressBook;
    private AddressBook sortedAscendingAddressBook;
    private AddressBook sortedDescendingAddressBook;

    @Before
    public void setUp() throws Exception {
        Person chitose = new Person(new Name("Chitose Karasuma"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), Collections.emptySet());
        Person kazuha = new Person(new Name("Kazuha Shibasaki"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                Collections.emptySet());
        Person koto = new Person(new Name("Koto Katakura"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), Collections.emptySet());
        Person momoka = new Person(new Name("Momoka Sonou"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                Collections.emptySet());
        Person yae  = new Person(new Name("Yae Kugayama"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), Collections.emptySet());

        addressBook = TestUtil.createAddressBook(kazuha, chitose, yae, koto, momoka); //use some random order to verify sorting works properly
        sortedAscendingAddressBook = TestUtil.createAddressBook(chitose, kazuha, koto, momoka, yae);
        sortedDescendingAddressBook = TestUtil.createAddressBook(yae, momoka, koto, kazuha, chitose);
    }

    @Test
    public void execute_sortsCorrectly() {
        //sort in ascending order
        assertSortCommandBehavior(true, sortedAscendingAddressBook.getAllPersons());

        //sort in descending order
        assertSortCommandBehavior(false, sortedDescendingAddressBook.getAllPersons());
    }

    /**
     * Executes the sort command and verifies the result matches the persons in the
     * expectedPersonList exactly and in the correct order.
     */
    private void assertSortCommandBehavior(boolean ascendingOrder, UniquePersonList expectedPersonList) {
        SortCommand command = createSortCommand(ascendingOrder);
        command.execute();
        assertEquals(expectedPersonList, command.addressBook.getAllPersons());
    }

    private SortCommand createSortCommand(boolean ascendingOrder) {
        SortCommand command = new SortCommand(ascendingOrder);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
