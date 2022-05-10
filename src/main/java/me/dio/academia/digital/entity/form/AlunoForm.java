package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa ter entre {min} e {max} caracteres")
    private String nome;

    @NotBlank(message = "CPF não pode ser vazio")
    //@CPF(message = "valor '${validatedValue}' é inválido")
    private String cpf;

    @NotBlank(message = "Bairro não pode ser vazio")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa ter entre {min} e {max} caracteres")
    private String bairro;

    @NotNull
    @Past(message = "'${validatedValue}' é inválida")
    private LocalDate dataDeNascimento;
}
