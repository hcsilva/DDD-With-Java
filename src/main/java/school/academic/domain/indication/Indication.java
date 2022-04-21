package school.academic.domain.indication;

import school.academic.domain.student.Student;

import java.time.LocalDateTime;

public class Indication {

    private Student indicated;
    private Student indicatedBy;
    private LocalDateTime indicationDate;

    public Indication(Student indicated, Student indicatedBy) {
        this.indicated = indicated;
        this.indicatedBy = indicatedBy;
        this.indicationDate = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public void setIndicated(Student indicated) {
        this.indicated = indicated;
    }

    public Student getIndicatedBy() {
        return indicatedBy;
    }

    public void setIndicatedBy(Student indicatedBy) {
        this.indicatedBy = indicatedBy;
    }
}
