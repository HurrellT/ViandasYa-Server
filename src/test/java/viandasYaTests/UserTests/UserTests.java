package viandasYaTests.UserTests;

import org.junit.Test;
import app.model.Exceptions.InvalidEmailException;
import app.model.Exceptions.InvalidPhoneNumberException;
import app.model.User.Client.Client;
import app.model.User.Client.ClientFactory;

import static org.junit.Assert.assertEquals;

public class UserTests {

    //Using Client
    @Test
    public void testChangeNameTo_TheClientTomasHurrellChangesHisNameToPepitoHurrell() {
        Client client = ClientFactory.tomasHurrell();

        assertEquals("Tomas", client.name);
        assertEquals("Hurrell", client.lastname);

        client.changeNameTo("Pepito");

        assertEquals("Pepito", client.name);
    }

    @Test
    public void testUpdatePhoneNumberTo_TomasHurrellChangesHisPhoneNumberTo5491198765432To5491112345678() {
        Client client = ClientFactory.tomasHurrell();

        assertEquals("+5491198765432", client.phone);

        client.updatePhoneNumberTo("+5491112345678");

        assertEquals("+5491112345678", client.phone);
    }

    @Test(expected = InvalidPhoneNumberException.class)
    public void testUpdatePhoneNumberTo_TomasHurrellCannotChangeHisPhoneNumberTo123BecauseItsAnInvalidNumber() {
        Client client = ClientFactory.tomasHurrell();

        assertEquals("+5491198765432", client.phone);

        client.updatePhoneNumberTo("123");
    }

    @Test
    public void testUpdateEmailTo_TomasHurrellChangesHisEmailFromHurrelltomasAtGmailDotComToHurrellAtGmailDotCom() {
        Client client = ClientFactory.tomasHurrell();

        assertEquals("hurrelltomas@gmail.com", client.email);

        client.updateEmailTo("hurrell@gmail.com");

        assertEquals("hurrell@gmail.com", client.email);
    }


    @Test(expected = InvalidEmailException.class)
    public void testUpdateEmailTo_TomasHurrellCannotChangeHisEmailToHurrellGmailDotComBecauseItsAnInvalidEmail() {
        Client client = ClientFactory.tomasHurrell();

        assertEquals("hurrelltomas@gmail.com", client.email);

        client.updateEmailTo("hurrellgmail.com");
    }

    @Test
    public void testUpdateAddressTo_TomasHurrellChangesHisAddressFromUnq123ToRoqueSaenzPeña352() {
        Client client = ClientFactory.tomasHurrell();

        assertEquals("Unq 123", client.address);

        client.updateAddressTo("Roque Saenz Peña 352");

        assertEquals("Roque Saenz Peña 352", client.address);
    }

    @Test
    public void testUpdateStateTo_TomasHurrellChangesHisStateFromBernalToSanNicolas() {
        Client client = ClientFactory.tomasHurrell();

        assertEquals("Bernal", client.state);

        client.updateStateTo("San Nicolas");

        assertEquals("San Nicolas", client.state);
    }

    @Test
    public void testANewClientHasAnAccountWithCredit0() {

        Client client = ClientFactory.federicoMartinez();

        assertEquals(0, client.getAccountCredit(), 0.0);
    }

    @Test
    public void testAddCredit_FedericoMartinezAddsCreditToHisAccount() {

        Client client = ClientFactory.federicoMartinez();

        client.addCredit(5);

        assertEquals(5, client.getAccountCredit(), 0.0);
    }

    @Test
    public void testAddCredit_FedericoMartinezSubtractCreditFromHisAccount() {

        Client client = ClientFactory.federicoMartinez(); //

        client.addCredit(5);
        client.subtractCredit(3);

        assertEquals(2, client.getAccountCredit(), 0.0);
    }

}
