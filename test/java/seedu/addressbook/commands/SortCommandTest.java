package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private Command sortCommand;

    private AddressBook addressBook;
    private List<ReadOnlyPerson> expectedSortedAllPersons;
    private List<? extends ReadOnlyPerson> outputAllPersons;

    @Before
    public void setUp() throws Exception {
        Person adam = new Person(new Name("Adam"), new Phone("62111111", false),
                new Email("adam@gmail.com", false), new Address("333 Adam Road", false), new UniqueTagList());
        Person ben = new Person(new Name("Ben"), new Phone("62111112", false),
                new Email("adam@gmail.com", false), new Address("333 Ben Road", false), new UniqueTagList());
        Person bard = new Person(new Name("Bard"), new Phone("62111114", false),
                new Email("adam@gmail.com", false), new Address("333 Bard Road", false), new UniqueTagList());
        Person alex = new Person(new Name("Alex"), new Phone("62111113", false),
                new Email("adam@gmail.com", false), new Address("333 Alex Road", false), new UniqueTagList());

        addressBook = TestUtil.createAddressBook(adam, ben, bard, alex);
        expectedSortedAllPersons = TestUtil.createList(adam, alex, bard, ben);
    }

    @Test
    public void execute() {
        sortCommand = new SortCommand();
        sortCommand.setData(addressBook, Collections.emptyList());
        assertSortedList(expectedSortedAllPersons);
    }

    /**
     * Executes the sort command verifies the all persons list
     * matches the expected all persons list
     */
    private void assertSortedList(List<ReadOnlyPerson> expectedAllPersons) {
        CommandResult result = sortCommand.execute();
        if (result.getRelevantPersons().isPresent()) {
            outputAllPersons = result.getRelevantPersons().get();
        }
        assertEquals(expectedAllPersons, outputAllPersons);
    }
}

