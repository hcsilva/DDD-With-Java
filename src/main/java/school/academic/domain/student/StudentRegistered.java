package school.academic.domain.student;

import school.shared.domain.events.Event;
import school.shared.domain.CPF;
import school.shared.domain.events.EventType;

import java.time.LocalDateTime;
import java.util.Map;

public class StudentRegistered implements Event {

    private final CPF cpfStudent;
    private final LocalDateTime moment;

    public StudentRegistered(CPF cpfStudent) {
        this.cpfStudent = cpfStudent;
        this.moment = LocalDateTime.now();
    }

    @Override
    public LocalDateTime moment() {
        return null;
    }

    @Override
    public EventType type() {
        return EventType.REGISTERED_STUDENT;
    }

    @Override
    public Map<String, Object> informations() {
        return Map.of("cpf", cpfStudent);
    }

    public CPF getCpfStudent() {
        return cpfStudent;
    }
}
