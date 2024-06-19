package com.bekprotek.bekprotek.services;

import com.bekprotek.bekprotek.entities.productEntity;
import com.bekprotek.bekprotek.repositories.productRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class productServiceTest {

    @Mock
    private productRepository productrepo;

    @InjectMocks
    private productService productService;

    private productEntity existingProduct;
    private productEntity newProduct;

    @BeforeEach
    void setUp() {
        existingProduct = new productEntity();
        existingProduct.setId(1L);
        existingProduct.setName("Existing Product");
        existingProduct.setDesc("Existing Description");

        newProduct = new productEntity();
        newProduct.setName("New Product");
        newProduct.setDesc("New Description");
    }

    @Test
    void testGetProductsWithData() {
        when(productrepo.findAll()).thenReturn(Arrays.asList(existingProduct, newProduct));

        Collection<productEntity> products = productService.getProducts();

        assertNotNull(products);
        assertEquals(2, products.size());
    }

    @Test
    void testGetProductsNoData() {
        when(productrepo.findAll()).thenReturn(Collections.emptyList());

        Collection<productEntity> products = productService.getProducts();

        assertNotNull(products);
        assertTrue(products.isEmpty());
    }

    @Test
    void testGetProductWithValidId() {
        when(productrepo.findById(1L)).thenReturn(Optional.of(existingProduct));

        Optional<productEntity> product = productService.getProduct(1L);

        assertTrue(product.isPresent());
        assertEquals(existingProduct, product.get());
    }

    @Test
    void testGetProductWithInvalidId() {
        when(productrepo.findById(2L)).thenReturn(Optional.empty());

        Optional<productEntity> product = productService.getProduct(2L);

        assertFalse(product.isPresent());
    }

    @Test
    void testSaveExistingProduct() {
        when(productrepo.save(existingProduct)).thenReturn(existingProduct);

        productEntity savedProduct = productService.saveProduct(existingProduct);

        assertNotNull(savedProduct);
        assertEquals(existingProduct, savedProduct);
    }

    @Test
    void testSaveNewProduct() {
        when(productrepo.save(newProduct)).thenReturn(newProduct);

        productEntity savedProduct = productService.saveProduct(newProduct);

        assertNotNull(savedProduct);
        assertEquals(newProduct, savedProduct);
    }

    @Test
    void testSaveProductWithEmptyName() {
        productEntity productWithEmptyName = new productEntity();
        productWithEmptyName.setDesc("Description without name");

        assertThrows(IllegalArgumentException.class, () -> {
            productService.saveProduct(productWithEmptyName);
        });
    }

    @Test
    void testSaveProductWithEmptyDescription() {
        productEntity productWithEmptyDescription = new productEntity();
        productWithEmptyDescription.setName("Name without description");

        assertThrows(IllegalArgumentException.class, () -> {
            productService.saveProduct(productWithEmptyDescription);
        });
    }

    @Test
    void testSaveProductWithNameAlreadyExists() {
        when(productrepo.save(any(productEntity.class))).thenThrow(new IllegalArgumentException("Product name already exists"));

        assertThrows(IllegalArgumentException.class, () -> {
            productService.saveProduct(newProduct);
        });
    }

    @Test
    void testSaveNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            productService.saveProduct(null);
        });
    }
}
