package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    /**
     *
     * @param dataNascimento: data de nascimento dos alunos
     * @return lista de alunos com base na data de nascimento especificada
     */
    List<Aluno> findByDataDeNascimento(LocalDate dataNascimento);
}
