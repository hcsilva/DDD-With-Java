package school.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.academic.domain.student.Telephone;


class TelephoneTest {

    @Test
    void shouldntCreateTelephoneWithInvalidDDD() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Telephone("555", "32211556"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Telephone("", ""));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Telephone(null, null));
    }


    @Test
    void shouldntCreateTelephoneWithInvalidNumber() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Telephone("55", "3221155678"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Telephone("55", ""));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Telephone("55", null));
    }


    @Test
    void createTelephoneDDDAndNumberValids() {
        String ddd = "54";
        String number = "32211556";
        Assertions.assertDoesNotThrow(
                () -> new Telephone(ddd, number));

        Telephone phone = new Telephone(ddd, number);
        Assertions.assertEquals(ddd, phone.getDdd());
        Assertions.assertEquals(number, phone.getNumber());
    }


}