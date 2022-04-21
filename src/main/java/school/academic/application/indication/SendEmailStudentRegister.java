package school.academic.application.indication;

import school.academic.domain.student.Student;

public interface SendEmailStudentRegister {

    void sendFor(Student student);
}
