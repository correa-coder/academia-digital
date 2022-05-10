package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getAvaliacaoFisica(@PathVariable Long id) {
        Optional<AvaliacaoFisica> avaliacaoFisicaOptional = service.get(id);

        if (avaliacaoFisicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não uma valiação física com o ID especificado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoFisicaOptional.get());
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

    @PostMapping
    public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> updateAvaliacao(@PathVariable  Long id,
                                              @RequestBody AvaliacaoFisicaUpdateForm form) {
        Optional<AvaliacaoFisica> avaliacaoFisicaOptional = service.get(id);

        if (avaliacaoFisicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe a avaliação física com o ID especificado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, form));
    }

    @DeleteMapping(path = "{avaliacaoId}")
    public void delete(@PathVariable("avaliacaoId") Long id) {
        service.delete(id);
    }
}
