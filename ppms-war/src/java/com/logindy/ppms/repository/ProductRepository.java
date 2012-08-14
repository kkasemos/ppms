/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.repository;

import com.logindy.ppms.entity.PartModel;
import com.logindy.ppms.entity.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author krit
 */
public class ProductRepository {
    private static ProductRepository repository;

    List<Product> products;
    
    public static ProductRepository getInstance() {
        
        if(null == repository) {
            repository = new ProductRepository();
            repository.add(new Product("Product A", 
                    new PartModel("Part A", "Model A")));
            repository.add(new Product("Product B", 
                    new PartModel("Part B", "Model B")));
        }
        
        return repository;
    }
    
    public ProductRepository() {
        products = new ArrayList<Product>();
    }
    
    public void add(Product product) {
        products.add(product);
    }

    public List<Product> searchByProductName(String name) {        
        return search("name", name);
    }   

    private List<Product> search(String fieldName, String name) {
        List<Product> results = new ArrayList<Product>();
        Comparator comparator = getComparator(fieldName);
        
        for(Product product: products) {
            if(0 == comparator.compare(product, name)) {
                results.add(product);
            }
        }
        
        return results;
    }

    private Comparator getComparator(String fieldName) {
        return new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Product product = (Product)o1;
                String name = (String)o2;
                
                if(product.getName().equals(name)) {
                    return 0;
                }
                
                return 1;
            }
            
        };
    }
}
