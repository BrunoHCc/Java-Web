package pw3.ifsp.controller;

import pw3.ifsp.dao.GenericDao;
import pw3.ifsp.dao.GenericDaoJpa;
import pw3.ifsp.models.Aluno;

import java.util.List;

public class alunoController {
    private final GenericDao<Aluno, Long> dao;

    public alunoController() {
        dao = new GenericDaoJpa<>(Aluno.class);
    }

    public void createAluno(String nome, String ra, String email, Double nota1, Double nota2, Double nota3)
    {
        Aluno aluno = new Aluno(nome, ra, email, nota1, nota2, nota3);
        dao.create(aluno);
    }
    public void updateAluno(Long id, String nome, String ra, String email, Double nota1, Double nota2, Double nota3)
    {
        Aluno aluno = new Aluno(id, nome, ra, email, nota1, nota2, nota3);
        dao.update(aluno);
    }
    public void deleteAluno(Long id)
    {
        dao.delete(id);
    }
    public List<Aluno> findAlunoByName(String nome) {
        return dao.findByName(nome);
    }

    public Aluno findAluno(Long id)
    {
        return dao.find(id);
    }
    public List<Aluno> findAllAluno()
    {
        return dao.findAll();
    }
}
