package com.hivison.java.study.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Invoice {
    private Long id;
    private String number;
    private List<Product> products;


    /*
     * REFACTOR 1
     *
     * public List<Long> getProductsIds(){
     *  final List<Long> ids = new ArrayList<>();
     *
     *  if (products != null) {
     *      for (Product product : products) {
     *      ids.add(product.getId());
     *
     *      }
     *  }
     *
     *  return ids;
     *  }
     */

    /*
     *  REFACTOR 2
     *
     *  public List<Long> getProductsIds() {
     *   final List<Long> ids = new ArrayList<>();
     *
     *   if (products != null) {
     *       products.forEach(p -> ids.add(p.getId()));
     *       }
     *
     *  return ids;
     *  }
     */

    public List<Long> getProductsIds(){
        return Optional.ofNullable(products)
                .map(List::stream).orElse(Stream.empty())
                .map(Product::getId)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Invoice addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }

        products.add(product);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(getId(), invoice.getId()) &&
                Objects.equals(getNumber(), invoice.getNumber()) &&
                Objects.equals(getProducts(), invoice.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getProducts());
    }
}
