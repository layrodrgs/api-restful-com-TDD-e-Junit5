package org.example;

import jdk.nashorn.internal.ir.CaseNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas.")
    public void deveCriarCadastroDePessoas(){
        //cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //verificação
        Assertions.assertThat( cadastro.getPessoas() ).isEmpty();
    }

   @Test
   @DisplayName("Deve adicionar uma pessoa.")
    public void deveAdicionarUmaPessoa(){
        //cenario
       CadastroPessoas cadastroPessoas = new CadastroPessoas();
       Pessoa pessoa = new Pessoa();
       pessoa.setNome("Layanne");

       //execução
       cadastroPessoas.adicionar(pessoa);

       //verificação
       Assertions.assertThat(cadastroPessoas.getPessoas())
               .isNotEmpty()
               .hasSize(1)
               .contains(pessoa);
    }

    @Test
    @DisplayName("Não deve adicionar pessoa com o nome vazio.")
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
       org.junit.jupiter.api.Assertions
               .assertThrows(PessoaSemNomeException.class, () -> cadastroPessoas.adicionar(pessoa));
    }

    @Test
    @DisplayName("Deve remover uma pessoa.")
    public void  deveRemoverUmaPessoa(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Layanne");
        cadastroPessoas.adicionar(pessoa);

        //execução
        cadastroPessoas.remover(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve lançar erro ao tentar remover pessoa inexistente.")
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
      org.junit.jupiter.api.Assertions
              .assertThrows(CadastroVazioException.class, () -> cadastroPessoas.remover(pessoa));
    }
}
