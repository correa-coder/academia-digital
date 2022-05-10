package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getAluno(@PathVariable  Long id) {
        Optional<Aluno> alunoOptional = service.get(id);

        if (alunoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o aluno com o ID especificado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunoOptional.get());
    }

    @GetMapping
    public List<Aluno> getAll(
            @RequestParam(value = "dataNascimento", required = false) String dataNascimento) {
        return service.getAll(dataNascimento);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable  Long id) {
        Optional<Aluno> alunoOptional = service.get(id);

        if (alunoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o aluno com o ID especificado");
        }
        service.delete(alunoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno com o ID " + id + "deletado");
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaById(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaById(id);
    }
}
