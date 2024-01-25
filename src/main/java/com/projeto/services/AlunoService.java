package com.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.entites.Aluno;
import com.projeto.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long idAluno) {
        Optional<Aluno> aluno = alunoRepository.findById(idAluno);
        return aluno.orElse(null);
    }

    public Aluno salvarAlunos(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long idAluno, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(idAluno);
        if (existingAluno.isPresent()) {
            updatedAluno.setIdAluno(idAluno);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }
    public boolean deleteAluno(Long idAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(idAluno);
        if (existingAluno.isPresent()) {
        	alunoRepository.deleteById(idAluno);
           return true;
        }
        return false;
    }
}