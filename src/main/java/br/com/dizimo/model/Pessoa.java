package br.com.dizimo.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private LocalDateTime dataNascimento;

    @CPF
    @Column(unique = true , nullable = false)
    private String cpf;

    @Email
    private String email;

    private String telefone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
}
