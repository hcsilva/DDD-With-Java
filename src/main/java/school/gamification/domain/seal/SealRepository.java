package school.gamification.domain.seal;

import school.shared.domain.CPF;

import java.util.List;

public interface SealRepository {

    void add(Seal seal);

    List<Seal> StudentSealsByCPF(CPF cpf);
}
