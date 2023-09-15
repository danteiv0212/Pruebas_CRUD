package com.crudprueba.Instrumentos.Product.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class ProductDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    private String type;
    private float price;

    public ProductDomain() {
    }

    public ProductDomain(Long id, String code, String name, String type, float price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public ProductDomain(String code, String name, String type, float price) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
