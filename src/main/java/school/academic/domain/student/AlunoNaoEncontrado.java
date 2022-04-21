package school.academic.domain.student;

import school.shared.domain.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getNumber());
    }

}
