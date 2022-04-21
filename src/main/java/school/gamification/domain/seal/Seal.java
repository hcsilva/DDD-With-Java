package school.gamification.domain.seal;

import school.shared.domain.CPF;

public class Seal {

    private CPF studentCpf;
    private String name;


    public Seal(CPF studentCpf, String name) {
        this.studentCpf = studentCpf;
        this.name = name;
    }

    public CPF getStudentCpf() {
        return studentCpf;
    }

    public String getName() {
        return name;
    }
}
