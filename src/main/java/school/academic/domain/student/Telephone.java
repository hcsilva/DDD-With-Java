package school.academic.domain.student;

public class Telephone {

    private String ddd;
    private String number;

    public Telephone(String ddd, String number) {
        if (ddd == null || ddd.length() != 2) {
            throw new IllegalArgumentException("DDD inválido");
        }

        if (number == null || number.length() != 8) {
            throw new IllegalArgumentException("Número inválido");
        }

        this.ddd = ddd;
        this.number = number;
    }


    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
