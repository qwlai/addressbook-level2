package seedu.addressbook.data.person;

import seedu.addressbook.data.address.Block;
import seedu.addressbook.data.address.PostalCode;
import seedu.addressbook.data.address.Street;
import seedu.addressbook.data.address.Unit;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "block, street, unit, postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person's address invalid. It should be in this format a/" + EXAMPLE;
    public static final String ADDRESS_VALIDATION_REGEX = "^([^,]*,\\s){3}[^,]*";
    private static final String ADDRESS_PARTS_SEPARATOR = ", ";

    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /* A String array is used to store address of a single person.
     * The constants given below are the indexes for the different parts of the address
     * For example, the block of the address is stored as the 0th element in the array.
     */
    private final int ADDRESS_BLOCK_INDEX = 0;
    private final int ADDRESS_STREET_INDEX = 1;
    private final int ADDRESS_UNIT_INDEX = 2;
    private final int ADDRESS_POSTAL_CODE_INDEX = 3;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        processAddress(trimmedAddress);
    }

    private void processAddress(String trimmedAddress) {
        String[] trimmedAddressParts = trimmedAddress.split(ADDRESS_PARTS_SEPARATOR);
        block = new Block(trimmedAddressParts[ADDRESS_BLOCK_INDEX]);
        street = new Street(trimmedAddressParts[ADDRESS_STREET_INDEX]);
        unit = new Unit(trimmedAddressParts[ADDRESS_UNIT_INDEX]);
        postalCode = new PostalCode(trimmedAddressParts[ADDRESS_POSTAL_CODE_INDEX]);
    }

    private String getAddress() {
        return block.getBlock() + ADDRESS_PARTS_SEPARATOR + street.getStreet() + ADDRESS_PARTS_SEPARATOR
                + unit.getUnit() + ADDRESS_PARTS_SEPARATOR + postalCode.getPostalCode();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return getAddress();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getAddress().equals(((Address) other).getAddress())); // state check
    }

    @Override
    public int hashCode() {
        return getAddress().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
