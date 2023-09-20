package com.crudprueba.Instrumentos.Product.Repository;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, Long> {
    Optional<ProductDomain> findProductByCode(String code);
//    ProductDomain findProductByCode(String code);
    Optional<ProductDomain> findProductById(Long Id);

    boolean existsByCode(String testCode);
}
