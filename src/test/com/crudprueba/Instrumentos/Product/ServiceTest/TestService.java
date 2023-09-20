package com.crudprueba.Instrumentos.Product.ServiceTest;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;
import com.crudprueba.Instrumentos.Product.Repository.ProductRepository;
import com.crudprueba.Instrumentos.Product.Service.ProductService;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.ResultActions;
import org.yaml.snakeyaml.events.Event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TestService {
    HashMap<String, Object> datos;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductService productService;
    @Mock
    private ProductDomain productDomain;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }

//    Services
    @Test
    void TestgetProducts() {
//        When
        productService.getProducts();
//        Then
        verify(this.productRepository).findAll();
    }

    @Test
    void TestpostProduct() {
//        given
        ProductDomain productDomain = new ProductDomain(
                "BAE04",
                "BAJO",
                "ACUSTICO",
                1600);
//        when
        String TestCode = productDomain.getCode();
        productService.postProduct(productDomain);
        boolean existe = this.productRepository.existsByCode(TestCode);

        if (productDomain.getCode() == null) {
//        then
            ArgumentCaptor<ProductDomain> productArgumentCaptor = ArgumentCaptor.
                    forClass(ProductDomain.class);
            verify(this.productRepository).save(productArgumentCaptor.capture());
            ProductDomain capturedProduct = productArgumentCaptor.getValue();
            assertThat(capturedProduct).isEqualTo(productDomain);
        }
        if (productDomain.getCode() != null) {
//        then
            assertThat(existe).isFalse();
        }

    }

    @Test
    void TestputProduct() {
//        given
        ProductDomain productDomain = new ProductDomain(
                "BAE04",
                "BAJO",
                "ACUSTICO",
                1600);
        long TestID = 1L;

        boolean existe = this.productRepository.existsById(TestID);

        if(existe){
            ArgumentCaptor<ProductDomain> productArgumentCaptor =ArgumentCaptor.forClass(ProductDomain.class);
            verify(productRepository).save(productArgumentCaptor.capture());
            ProductDomain capturedProduct = productArgumentCaptor.getValue();
            assertThat(capturedProduct).isEqualTo(productDomain);
        }
        if(!existe) {

            assertThat(existe).isFalse();
        }

//        when


    }

    @Test
    void TestdeleteProduct() {

        long TestID = 1L;

            boolean existe = this.productRepository.existsById(TestID);

            if(existe){
                ArgumentCaptor<ProductDomain> productArgumentCaptor =ArgumentCaptor.forClass(ProductDomain.class);
                verify(productRepository).delete(productArgumentCaptor.capture());
                ProductDomain capturedProduct = productArgumentCaptor.getValue();
                assertThat(capturedProduct).isEqualTo(productDomain);
            }
            if(!existe) {

                assertThat(existe).isFalse();
            }
    }


}