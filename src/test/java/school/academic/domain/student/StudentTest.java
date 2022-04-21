package school.academic.domain.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.shared.domain.CPF;

class StudentTest {

    private Student student;

    @BeforeEach
    void beforeEach() {
        this.student = new Student(
                new CPF("30017870070"),
                "Fulano",
                new Email("fulano@gmail.com"));
    }

    @Test
    void shouldAllowsAddOneTelephone() {
        this.student.addTelephone("11", "32211556");
        Assertions.assertEquals(1, this.student.getTelephones().size());
    }

    @Test
    void shouldAllowsAddTwoTelephones() {
        this.student.addTelephone("11", "99999999");
        this.student.addTelephone("11", "88888888");
        Assertions.assertEquals(2, this.student.getTelephones().size());
    }

    @Test
    void shouldntAllowsAddThreeTelephones() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.student.addTelephone("11", "99999999");
            this.student.addTelephone("11", "88888888");
            this.student.addTelephone("11", "77777777");
        });
    }

}