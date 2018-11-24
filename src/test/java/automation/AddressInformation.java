package automation;

public class AddressInformation {
    public final String fullname;
    public final String street1;
    public final String street2;
    public final String city;
    public final String state;
    public final String zipcode;
    public final String phone;

    public AddressInformation(String fullname,
                              String street1,
                              String street2,
                              String city,
                              String state,
                              String zipcode,
                              String phone){
        this.fullname = fullname;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
    }

}
