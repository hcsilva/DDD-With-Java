package school.gamification.aplication;

import school.gamification.domain.seal.Seal;
import school.gamification.infra.seal.SealRepositoryMemory;
import school.shared.domain.CPF;
import school.shared.domain.events.Event;
import school.shared.domain.events.EventType;
import school.shared.domain.events.Listener;

public class GeneratedSealNewStudent extends Listener {

    private final SealRepositoryMemory sealRepositoryMemory;

    public GeneratedSealNewStudent(SealRepositoryMemory sealRepositoryMemory) {
        this.sealRepositoryMemory = sealRepositoryMemory;
    }

    @Override
    protected void reactTo(Event event) {
        CPF cpfStudent = (CPF) event.informations().get("cpf");
        Seal newStudent = new Seal(cpfStudent, "beginner");
    }

    @Override
    protected boolean shouldProcess(Event event) {
        return event.type() == EventType.REGISTERED_STUDENT;
    }
}
