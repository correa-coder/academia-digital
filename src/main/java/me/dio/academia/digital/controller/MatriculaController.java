package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getMatricula(@PathVariable  Long id) {
        Optional<Matricula> matriculaOptional = service.get(id);

        if (matriculaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe a matrícula com o ID especificado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(matriculaOptional.get());
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteMatricula(@PathVariable  Long id) {
        Optional<Matricula> matriculaOptional = service.get(id);

        if (matriculaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe a matrícula com o ID especificado");
        }
        service.delete(matriculaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Remoção da matrícula com o ID " + id);
    }
}
