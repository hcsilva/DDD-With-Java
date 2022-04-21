package school.academic.application.student.register;

import school.shared.domain.events.EventPuplisher;
import school.academic.domain.student.Student;
import school.academic.domain.student.StudentRegistered;
import school.academic.domain.student.StudentRepository;

public class RegisterStudent {

    private final StudentRepository repository;
    private final EventPuplisher eventPuplisher;


    public RegisterStudent(StudentRepository repository, EventPuplisher eventPuplisher) {
        this.repository = repository;
        this.eventPuplisher = eventPuplisher;
    }

    public void register(RegisterStudentDto studentData) {
        Student newStudent = studentData.createStudent();
        repository.register(newStudent);

        StudentRegistered event = new StudentRegistered(newStudent.getCpf());
        eventPuplisher.publish(event);
    }
}
