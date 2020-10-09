package org.example;


import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrimeiroTeste {

    @Mock
    Calculadora calculadora;


    int numero1 = 10, numero2 = 5;

    @BeforeEach
    public void setUp(){
     calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumeros() {
        // cenário
        //execução
        int resultado = calculadora.somar(numero1, numero2);

        //verificações
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test
    public void naoDeveSomarNumNegativo(){
        //cenario
        int num1 = -10, num2 =5;

        //execução
       org.junit.jupiter.api.Assertions.assertThrows( RuntimeException.class, () -> calculadora.somar( num1, num2));
    }

    @Test
    public void deveSubtrairDoisNumeros(){
        //cenário
        //execução
        int resultado = calculadora.subtrair(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    public void deveMultiplicarDoisNumeros(){
        //cenário
        //execução
        int resultado = calculadora.multiplicar(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(50);
    }

    @Test
    public void deveDividirDoisNumeros(){
        //cenário
        //execução
        float resultado = calculadora.divisao(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test
    public void naoDeveDividirPorZero(){
        //cenario
        int numero1 = 10, numero2 =0;

        //execução
     org.junit.jupiter.api.Assertions.assertThrows(ArithmeticException.class, () -> calculadora.divisao(numero1, numero2));
    }
}

class Calculadora {

    int somar(int num, int num2) {
        if(num < 0 || num2 < 0) {
            throw new RuntimeException("Não é permitido somar números negativos.");
        }
        return  num + num2;
    }

    int subtrair(int num, int num2){
        return num - num2;
    }

    int multiplicar (int num, int num2){
       return  num * num2;
    }

    float divisao (int num, int num2){
        return  num / num2;
    }
}
