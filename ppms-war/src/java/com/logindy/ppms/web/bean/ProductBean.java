/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.web.bean;

import com.logindy.ppms.entity.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author krit
 */
@ManagedBean
@RequestScoped
public class ProductBean {
    private Product product;
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public String getName() {
        return product.getName();
    }
}
