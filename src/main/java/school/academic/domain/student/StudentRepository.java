package school.academic.domain.student;

import school.shared.domain.CPF;

import java.util.List;

public interface StudentRepository {

    void register(Student student);

    Student findByCpf(CPF cpf);

    List<Student> findAllRegistered();

}
