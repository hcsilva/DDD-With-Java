package school.gamification.infra.seal;

import school.gamification.domain.seal.Seal;
import school.gamification.domain.seal.SealRepository;
import school.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SealRepositoryMemory implements SealRepository {

    private List<Seal> seals = new ArrayList<>();

    @Override
    public void add(Seal seal) {
        this.seals.add(seal);
    }

    @Override
    public List<Seal> StudentSealsByCPF(CPF cpf) {
        return this.seals
                .stream()
                .filter(s -> s.getStudentCpf().equals(cpf))
                .collect(Collectors.toList());
    }
}
