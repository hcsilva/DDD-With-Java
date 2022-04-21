package school.academic.domain.student;

import school.shared.domain.CPF;

public class FactoryStudent {

    private Student student;

    public FactoryStudent withNameCpfEmail(String name, String cpf, String email) {
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public FactoryStudent withTelephone(String ddd, String number) {
        this.student.addTelephone(ddd, number);
        return this;
    }

    public Student create() {
        return this.student;
    }

}
