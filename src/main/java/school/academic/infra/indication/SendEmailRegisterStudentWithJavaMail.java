package school.academic.infra.indication;

import school.academic.application.indication.SendEmailStudentRegister;
import school.academic.domain.student.Student;

public class SendEmailRegisterStudentWithJavaMail implements SendEmailStudentRegister {

    @Override
    public void sendFor(Student student) {
      //Logic to send email With Lib JavaMail
    }
}
