package school.academic.application.student.register;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.shared.domain.CPF;
import school.academic.domain.student.Student;
import school.academic.infra.student.StudentRepositoryMemory;

class RegisterStudentTest {


    @Test
    void studentShouldBePersisted() {
        StudentRepositoryMemory repositoryMemory = new StudentRepositoryMemory();
        RegisterStudent useCase = new RegisterStudent(repositoryMemory);

        RegisterStudentDto data = new RegisterStudentDto("fulano",
                "02232295044", "fulano@teste.com.br");
        useCase.register(data);

        Student studentFound = repositoryMemory.findByCpf(new CPF("02232295044"));
        Assertions.assertEquals("fulano", studentFound.getName());
        Assertions.assertEquals("02232295044", studentFound.getCpf());
        Assertions.assertEquals("fulano@teste.com.br", studentFound.getEmail());
    }


}