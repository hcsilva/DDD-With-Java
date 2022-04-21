package school.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.academic.domain.student.Email;


class EmailTest {

    @Test
    void shouldntCreateInvalidEmails() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Email("invalidEmail"));
    }

    @Test
    void CreateValidEmails() {
        Assertions.assertDoesNotThrow(
                () -> new Email("teste@gmail.com"));
    }

}