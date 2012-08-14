/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.repository;

import com.logindy.ppms.entity.PartModel;
import com.logindy.ppms.entity.Product;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author krit
 */
public class ProductRepositoryTest {
    
    ProductRepository productRepo;
    
    public ProductRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        productRepo = ProductRepository.getInstance();        
        //productRepo.add(new Product("Product A", new PartModel("Part A", "Model A")));
        //productRepo.add(new Product("Product B", new PartModel("Part B", "Model B")));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test_searchByProductName_ProductA_foundPartA_And_ModelA() {

        List<Product> products = productRepo.searchByProductName("Product A");

        Assert.assertEquals(1, products.size());

        Product product = products.get(0);
        PartModel partModel = product.getPartModel(0);

        Assert.assertEquals("Product A", product.getName());
        Assert.assertEquals("Part A", partModel.getPartName());
        Assert.assertEquals("Model A", partModel.getModelName());
    }

    @Test
    public void test_searchByProductName_ProductB_foundPartB_And_ModelB() {

        List<Product> products = productRepo.searchByProductName("Product B");

        Assert.assertEquals(1, products.size());

        Product product = products.get(0);
        PartModel partModel = product.getPartModel(0);

        Assert.assertEquals("Product B", product.getName());
        Assert.assertEquals("Part B", partModel.getPartName());
        Assert.assertEquals("Model B", partModel.getModelName());
    }    
    
    @Test
    public void test_searchByProductName_InvalidProduct_notFound() {
        
        List<Product> products = productRepo.searchByProductName("InvalidProduct");

        Assert.assertEquals(0, products.size());     
    }
}
