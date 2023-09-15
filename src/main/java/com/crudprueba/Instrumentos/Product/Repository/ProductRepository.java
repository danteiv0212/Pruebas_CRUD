package com.crudprueba.Instrumentos.Product.Repository;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, Long> {
    Optional<ProductDomain> findProductByCode(String code);
//    ProductDomain findProductByCode(String code);


}
