package school.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.shared.domain.CPF;

class CPFTest {

    @Test
    void shouldntCreateCPFWhenIsNullOrEmptyOrInvaid() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CPF("030"));
    }

    @Test
    void createCpfValid() {
        String cpf = "11524191027";

        Assertions.assertDoesNotThrow(
                () -> new CPF(cpf)
        );

        CPF cpfValido = new CPF(cpf);
        Assertions.assertEquals(cpf, cpfValido.getNumber());
    }

}