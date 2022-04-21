package school;

import school.academic.application.student.register.RegisterStudent;
import school.academic.application.student.register.RegisterStudentDto;
import school.academic.domain.student.LogStudentRegistered;
import school.academic.infra.student.StudentRepositoryMemory;
import school.gamification.aplication.GeneratedSealNewStudent;
import school.gamification.infra.seal.SealRepositoryMemory;
import school.shared.domain.events.EventPuplisher;

public class RegisterStudentCommandLineTest {

    public static void main(String[] args) {
        String name = "Fulano Teste";
        String cpf = "62950649068";
        String email = "teste@teste.com.br";

        EventPuplisher puplisher = new EventPuplisher();
        puplisher.add(new LogStudentRegistered());
        puplisher.add(new GeneratedSealNewStudent(new SealRepositoryMemory()));

        RegisterStudent registerStudent = new RegisterStudent(new StudentRepositoryMemory(), puplisher);
        registerStudent.register(new RegisterStudentDto(name, cpf, email));
    }

}
