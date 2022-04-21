package school.academic.domain.student;

import school.shared.domain.events.Event;
import school.shared.domain.events.Listener;

import java.time.LocalDateTime;

public class LogStudentRegistered extends Listener {

    public void reactTo(Event event) {
      //  String formatMoment = event.moment().format(DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm"));
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
                ((StudentRegistered) event).getCpfStudent(), LocalDateTime.now()));
    }


    @Override
    protected boolean shouldProcess(Event event) {
        return event instanceof StudentRegistered;
    }
}
