package school.academic.domain.student;

public class Email {
    // This class is call = Value Object
    //Because, this class don't differentiates one email from another

    private String address;

    public Email(String address) {
        if (address == null || !address.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("E-mail Inválido");
        }

        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
