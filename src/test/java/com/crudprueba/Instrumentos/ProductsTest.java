package com.crudprueba.Instrumentos;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;
import com.crudprueba.Instrumentos.Product.Repository.ProductRepository;
import com.crudprueba.Instrumentos.Product.Service.ProductService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductsServiceTest {
    @Autowired
    private ProductRepository repository;

    @Test
    @Rollback(value = false)
    public void postProductsTest() {
//        ProductDomain productDomain = new ProductDomain("BAE60", "BAJO", "ACÚSTICO", 1600);
        ProductDomain productDomain = new ProductDomain("GAE40", "GUITARRA", "ACÚSTICA", 1200);
        repository.save(productDomain);
        assertNotNull(productDomain);
    }
//    @Test
//    public void searchProductsTest() {
//        String code = "BAE60";
//        Optional<ProductDomain> productDomain = repository.findProductByCode(code);
//        assertThat(productService.getCode()).isEqualTo(code);
//    }

//    @Test
//    public void updateProductsTest(){
//        String codeProduct = "XXXXX";
//        ProductDomain productDomain = new ProductDomain(codeProduct, "XXXX", "XXX", 888);
//        productDomain.setId((long) '1');
//
//        repository.save(productDomain);
//
//        ProductDomain productcurrent = repository.findProductByCode(codeProduct);
//        assertThat(productcurrent.getCode()).isEqualTo(codeProduct);


    @Test
    public void loadProductsTest() {
        List<ProductDomain> productDomains = (List<ProductDomain>) repository.findAll();
        assertThat(productDomains).size().isGreaterThan(0);

    }


}
