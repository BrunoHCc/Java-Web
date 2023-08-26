package pw3.ifsp.models;

import jakarta.persistence.*;

import java.math.RoundingMode;
@Entity
@Table(name="aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ra;
    private String email;
    private Double nota1;
    private Double nota2;
    private Double nota3;


    public Aluno(Long id, String nome, String ra, String email, Double nota1, Double nota2, Double nota3) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    public Aluno(String nome, String ra, String email, Double nota1, Double nota2, Double nota3) {
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    public Aluno(){}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public String getEmail() {
        return email;
    }

    public Double getNota1() {
        return nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nnome: " + nome +
                "\nra: " + ra +
                "\nemail:" + email +
                "\nnota1:" + nota1 +
                "\nnota2:" + nota2 +
                "\nnota3:" + nota3 ;
    }
}
