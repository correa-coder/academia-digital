package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IAlunoService {
    /**
     * Cria um Aluno e salva no banco de dados.
     * @param form formulário referente aos dados para criação de um Aluno no banco de dados.
     * @return Aluno recém-criado.
     */
    Aluno create(AlunoForm form);

    /**
     * Retorna um Aluno que está no banco de dados de acordo com seu Id.
     * @param id id do Aluno que será exibido.
     * @return Aluno de acordo com o Id fornecido.
     */
    Optional<Aluno> get(Long id);

    /**
     * Retorna os Alunos que estão no banco de dados.
     * @param dataNascimento: data de nascimento do aluno (opcional)
     * @return Uma lista os Alunos que estão salvas no DB.
     */
    List<Aluno> getAll(String dataNascimento);

    /**
     * Atualiza o Aluno.
     * @param id id do Aluno que será atualizado.
     * @param formUpdate formulário referente aos dados necessários para atualização do Aluno
     * no banco de dados.
     * @return Aluno recém-atualizado.
     */
    Aluno update(Long id, AlunoUpdateForm formUpdate);

    /**
     * Deleta um Aluno específico.
     * @param aluno: O aluno que será removido.
     */
    void delete(Aluno aluno);

    /**
     * @param id id do aluno que a lista de avaliações pertence
     * @return uma lista com todas as avaliações do aluno de acordo com o Id
     */
    List<AvaliacaoFisica> getAllAvaliacaoFisicaById(Long id);

}
