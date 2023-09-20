package com.crudprueba.Instrumentos.Product.Test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductTest {

    @Test
    void InstrumentosApplication(){}

    Calculator calculator = new Calculator();
    class Calculator {

        int add(int a, int b){
            return a+b;
        }
    }
    @Test
    void itShouldAddNumber(){

        int numberOne =20;
        int numberTwo =31;
        int result=calculator.add(numberOne, numberTwo);
        int expected = 51;
        assertThat(result).isEqualTo(expected);
    }





}
