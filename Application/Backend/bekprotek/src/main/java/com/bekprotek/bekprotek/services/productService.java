package com.bekprotek.bekprotek.services;

import com.bekprotek.bekprotek.repositories.productRepository;
import com.bekprotek.bekprotek.entities.productEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;

@Service
public class productService {

    private productRepository productrepo;

    @Autowired
    public productService(productRepository productrepo) {
        this.productrepo = productrepo;
    }

    public Collection<productEntity> getProducts() {
        return productrepo.findAll();
        //2 tests 1 wel data 1 geen data
    }

    public Optional<productEntity> getProduct(Long id) {
        return productrepo.findById(id);
        //2 tests wel valid id geen valid id
    }

    public productEntity saveProduct(productEntity product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (product.getDesc() == null || product.getDesc().isEmpty()) {
            throw new IllegalArgumentException("Product description cannot be empty");
        }
        else{
            return productrepo.save(product);
        }
        //2 bestaand product en nieuw product, empty name, empty desc, name already there, null product
    }

}
