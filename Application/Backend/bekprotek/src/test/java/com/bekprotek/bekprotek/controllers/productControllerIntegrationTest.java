package com.bekprotek.bekprotek.controllers;

import com.bekprotek.bekprotek.entities.productEntity;
import com.bekprotek.bekprotek.repositories.productRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class productControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private productRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private productEntity existingProduct;
    private productEntity newProduct;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();

        existingProduct = new productEntity();
        existingProduct.setName("Existing Product");
        existingProduct.setDesc("Existing Description");
        existingProduct = productRepository.save(existingProduct);

        newProduct = new productEntity();
        newProduct.setName("New Product");
        newProduct.setDesc("New Description");
    }

    @Test
    void testGetProducts() throws Exception {
        mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("Existing Product"));
    }

    @Test
    void testGetProductWithValidId() throws Exception {
        mockMvc.perform(get("/products/{id}", existingProduct.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Existing Product"));
    }

    @Test
    void testGetProductWithInvalidId() throws Exception {
        mockMvc.perform(get("/products/{id}", 999L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

/*    @Test
    void testCreateProduct() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/products/addproduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("New Product"));

        // Verify the product is actually saved in the database
        Optional<productEntity> savedProduct = productRepository.findById(
                Long.parseLong(resultActions.andReturn().getResponse().getContentAsString().split("\"id\":")[1].split(",")[0].trim()));
        assertTrue(savedProduct.isPresent());
        assertEquals("New Product", savedProduct.get().getName());
    }*/

/*    @Test
    void testCreateProductWithEmptyName() throws Exception {
        newProduct.setName("");

        mockMvc.perform(post("/products/addproduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isInternalServerError());
    }*/

/*    @Test
    void testCreateProductWithEmptyDescription() throws Exception {
        newProduct.setDesc("");

        mockMvc.perform(post("/products/addproduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isInternalServerError());
    }*/

/*    @Test
    void testCreateNullProduct() throws Exception {
        mockMvc.perform(post("/products/addproduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isInternalServerError());
    }*/
}
