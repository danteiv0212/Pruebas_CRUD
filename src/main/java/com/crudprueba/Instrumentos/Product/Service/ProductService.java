package com.crudprueba.Instrumentos.Product.Service;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;
import com.crudprueba.Instrumentos.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    HashMap<String, Object> datos;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDomain> getProducts() {
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> postProduct(ProductDomain productDomain) {
//    public void newProduct(Product product) {
        Optional<ProductDomain> resp = productRepository.
                findProductByCode(productDomain.getCode());
//        HashMap<String, Object> datos = new HashMap<>();
        datos = new HashMap<>();

        if (resp.isPresent()) {
            datos.put("error", true);
            datos.put("message", "Ya existe un producto con ese código");
//            throw new IllegalStateException("El producto ya existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT

            );
        }
        productRepository.save(productDomain);
        datos.put("data", productDomain);
        datos.put("message", "Se registró con éxito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }


    public ResponseEntity<Object> putProduct(ProductDomain productDomain) {
//    public void newProduct(Product product) {
//        Optional<Product> resp = productRepository.findProductByCode(product.getCode());
//        HashMap<String, Object> datos = new HashMap<>();
        datos = new HashMap<>();

        if (productDomain.getId() == null) {
            datos.put("error", true);
            datos.put("message", "Se requiere Id para la actualización");
//            throw new IllegalStateException("El producto ya existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT

            );
        }
        if (productDomain.getId() != null) {
            datos.put("message", "Se actualizó con éxito");

            productRepository.save(productDomain);
            datos.put("data", productDomain);
//            datos.put("message", "Se registró con éxito");
        }
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }


//    public ResponseEntity<Object> deleteProduct(ProductDomain productDomain) {
//        datos = new HashMap<>();
//        boolean existe = this.productRepository.existsById(productDomain.getId());
//        if (!existe) {
//            datos.put("error", true);
//            datos.put("message", "No existe un producto ligado a ese ID");
//            return new ResponseEntity<>(
//                    datos,
//                    HttpStatus.CONFLICT
//            );
//        }
//        productRepository.deleteById(productDomain.getId());
//        datos.put("message", "El producto se eliminó exitosamente");
//        return new ResponseEntity<>(
//                datos,
//                HttpStatus.ACCEPTED
//        );

        public ResponseEntity<Object> deleteProduct(Long id){
            datos = new HashMap<>();
            boolean existe = this.productRepository.existsById(id);
            if(!existe){
                datos.put("error", true);
                datos.put("message","No existe un producto ligado a ese ID");
                return new ResponseEntity<>(
                        datos,
                        HttpStatus.CONFLICT
                );
            }
            productRepository.deleteById(id);
            datos.put("message","El producto se eliminó exitosamente");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.ACCEPTED
            );


    }
}
