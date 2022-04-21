package school.academic.infra.student;

import school.academic.domain.student.*;
import school.shared.domain.CPF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void register(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf().getNumber());
            ps.setString(1, student.getName());
            ps.setString(1, student.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telephone phone : student.getTelephones()) {
                ps.setString(1, phone.getDdd());
                ps.setString(2, phone.getNumber());
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findByCpf(CPF cpf) {
        try {
            String sql = "SELECT id, name, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            boolean find = rs.next();
            if (!find) throw new AlunoNaoEncontrado(cpf);

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student foundStudant = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, number FROM TELEPHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                foundStudant.addTelephone(ddd, number);
            }

            return foundStudant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAllRegistered() {
        try {
            String sql = "SELECT id, cpf, name, email FROM STUDENT";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(cpf, name, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, number FROM TELEPHONE WHERE student_id = ?";
                PreparedStatement psTelephone = connection.prepareStatement(sql);
                psTelephone.setLong(1, id);
                ResultSet rsTelephone = psTelephone.executeQuery();
                while (rsTelephone.next()) {
                    String number = rsTelephone.getString("number");
                    String ddd = rsTelephone.getString("ddd");
                    student.addTelephone(ddd, number);
                }

                students.add(student);
            }

            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
