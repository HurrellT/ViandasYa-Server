package viandasYaModel.Client;

import viandasYaModel.Exceptions.InvalidPhoneNumberException;

import java.util.regex.Pattern;

public class Client {

    //Parameters

    public String name;
    public String lastname;
    public String address;
    public String state;    //TODO: change to State ENUM ?
    public String email;
    public String phone;

    //Constructor

    public Client(String name, String lastname,
                  String address, String state,
                  String email, String phoneNumber) throws InvalidPhoneNumberException {

        isAValidPhoneNumber(phoneNumber);

        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.state = state;
        this.email = email;
        this.phone = phoneNumber;
    }

    //Methods

        //PhoneNumber

    //TODO: Discuss if we preffer to have this functionality in a PhoneNumberValidor / Manager object
    private void isAValidPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (!phoneNumber.matches("^(?:(?:00|\\+)?549?)?0?(?:11|[2368]\\d)(?:(?=\\d{0,2}15)\\d{2})??\\d{8}$"))
            throw new InvalidPhoneNumberException();
    }

    public void updatePhoneNumberTo(String newPhoneNumber) throws InvalidPhoneNumberException {
        isAValidPhoneNumber(newPhoneNumber);

        this.phone = newPhoneNumber;
    }

        // Name

    public void changeNameTo(String newName) {
        this.name = newName;
    }
}
