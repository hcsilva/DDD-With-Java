package school.academic.application.student.register;

import school.shared.domain.CPF;
import school.academic.domain.student.Email;
import school.academic.domain.student.Student;

public class RegisterStudentDto {

    private String studentName;
    private String studentCpf;
    private String studentEmail;

    public RegisterStudentDto(String studentName, String studentCpf, String studentEmail) {
        this.studentName = studentName;
        this.studentCpf = studentCpf;
        this.studentEmail = studentEmail;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCpf() {
        return studentCpf;
    }

    public void setStudentCpf(String studentCpf) {
        this.studentCpf = studentCpf;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Student createStudent() {
        return new Student(new CPF(this.studentCpf), this.studentName, new Email(this.studentEmail));
    }
}
