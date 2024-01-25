package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.entites.Aluno;
import com.projeto.services.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@Tag(name = "Alunos", description = "API REST DE GERENCIAMENTO DE Alunos")

@RestController
@RequestMapping("/alunos")

public class AlunoController {

   private final AlunoService alunoService;

   @Autowired

   public AlunoController(AlunoService alunoService) {
       this.alunoService = alunoService;

   }
   @GetMapping("/{id}")
   @Operation(summary = "Localiza Aluno por ID")

   public ResponseEntity<Aluno> getProductById(@PathVariable Long idAluno) {
    Aluno aluno = alunoService.getAlunoById(idAluno);
       if (aluno != null) {
           return ResponseEntity.ok(aluno);
       } else {
           return ResponseEntity.notFound().build();
       }
   }
   @GetMapping("/")

   @Operation(summary = "Apresenta todos os Alunos")
   public ResponseEntity<List<Aluno>> getAllAlunos() {
       List<Aluno> alunos = alunoService.getAllAlunos();
       return ResponseEntity.ok(alunos);

   }

   @PostMapping("/")
   @Operation(summary = "Cadastra um Aluno")
   public ResponseEntity<Aluno> criarAluno(@RequestBody @Valid Aluno aluno) {
    Aluno criarAluno = alunoService.salvarAlunos(aluno);
       return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);

   }
   @PutMapping("/{id}")
   @Operation(summary = "Altera o Aluno")

   public ResponseEntity<Aluno> updateAluno(@PathVariable Long idAluno, @RequestBody @Valid Aluno aluno) {
    Aluno updatedAluno = alunoService.updateAluno(idAluno, aluno);
       if (updatedAluno != null) {
           return ResponseEntity.ok(updatedAluno);
       } else {
           return ResponseEntity.notFound().build();
       }
   }



   @DeleteMapping("/{id}")
   @Operation(summary = "Deleta o Aluno")

   public ResponseEntity<String> deleteAluno(@PathVariable Long idAluno) {
       boolean deleted = alunoService.deleteAluno(idAluno);
       if (deleted) {
        return ResponseEntity.ok().body("O aluno foi excluído com sucesso.");
       } else {
           return ResponseEntity.notFound().build();
       }
   }
}