package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public Optional<AvaliacaoFisica> get(Long id) {
        return avaliacaoFisicaRepository.findById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacao = avaliacaoFisicaRepository.findById(id).get();

        avaliacao.setPeso(formUpdate.getPeso());
        avaliacao.setAltura(formUpdate.getAltura());

        return avaliacaoFisicaRepository.save(avaliacao);
    }

    @Override
    public void delete(Long id) {
        boolean exists = avaliacaoFisicaRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException("Não existe uma avaliação com o ID: " + id);
        }

        avaliacaoFisicaRepository.deleteById(id);
    }
}
