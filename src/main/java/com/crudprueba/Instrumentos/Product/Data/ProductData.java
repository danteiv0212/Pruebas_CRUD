package com.crudprueba.Instrumentos.Product.Data;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;

import java.util.Optional;

public class ProductData {

    public static Optional<ProductDomain> crearProducto0001(){
        return Optional.of(new ProductDomain(
                "BAE04",
                "BAJO",
                "ACUSTICO",
                1600));
    }
    public static Optional<ProductDomain> crearProducto0002(){
        return Optional.of(new ProductDomain(
                "BAF04",
                "BAJO FRETLESS",
                "ACUSTICO",
                1700));
    }
    public static Optional<ProductDomain> crearProducto0003(){
        return Optional.of(new ProductDomain(
                "GAE06",
                "GUITARRA",
                "ACUSTICA",
                1000));
    }
    public static Optional<ProductDomain> crearProducto0004(){
        return Optional.of(new ProductDomain(
                "GAE12",
                "DOCEROLLA",
                "ACUSTICA",
                1200));
    }

    public static Optional<ProductDomain> crearProducto0005(){
        return Optional.of(new ProductDomain(
                "UAE12",
                "UKULELE",
                "ACUSTICO",
                600));
    }

}
