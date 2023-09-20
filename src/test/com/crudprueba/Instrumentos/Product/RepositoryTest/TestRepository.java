package com.crudprueba.Instrumentos.Product.RepositoryTest;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;
import com.crudprueba.Instrumentos.Product.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TestRepository {

    @Autowired
    private ProductRepository underTest;

    @Test
    void findProductByCode() {
    }
}