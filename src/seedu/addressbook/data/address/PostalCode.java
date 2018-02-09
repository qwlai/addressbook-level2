package seedu.addressbook.data.address;

/**
 * Represents a PostalCode in the address.
 */
public class PostalCode {

    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public PostalCode(String postalCode) {

        this.postalCode = postalCode;
    }
}
