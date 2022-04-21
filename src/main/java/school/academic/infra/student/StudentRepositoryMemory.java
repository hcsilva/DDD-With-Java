package school.academic.infra.student;

import school.academic.domain.student.AlunoNaoEncontrado;
import school.shared.domain.CPF;
import school.academic.domain.student.Student;
import school.academic.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryMemory implements StudentRepository {

    private List<Student> registeredStudents = new ArrayList<>();

    @Override
    public void register(Student student) {
        this.registeredStudents.add(student);
    }

    @Override
    public Student findByCpf(CPF cpf) {
        return this.registeredStudents.stream()
                .filter(a -> a.getCpf().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Student> findAllRegistered() {
        return this.registeredStudents;
    }
}
