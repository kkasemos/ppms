/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.web.bean;

import com.logindy.ppms.entity.Part;
import com.logindy.ppms.entity.Product;
import com.logindy.ppms.repository.PartRepository;
import com.logindy.ppms.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author krit
 */
@ManagedBean
@RequestScoped
public class PartSearchBean {

    private String keyword;
    private String searchBy;
    
    /**
     * Creates a new instance of PartSearchBean
     */
    public PartSearchBean() {
    }
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public String getKeyword() {
        return keyword;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }    
    
    public String getSearchBy() {
        return searchBy;
    }
    
    public List<ProductBean> getProducts() {
        
        List<Product> products;              
        
        if(null == keyword || "".equals(keyword)) {
            products = new ArrayList<Product>();
        } else {
            products = ProductRepository.getInstance()
                .searchByProductName(keyword);
        }
        
        List<ProductBean> productBeans = new ArrayList<ProductBean>();
        
        for(Product product: products) {
            ProductBean productBean = new ProductBean();       
            productBean.setProduct(product);            
            productBeans.add(productBean);
        }
        
        return productBeans;
    }
    
    public List<PartBean> getParts() {
        
        List<Part> parts;              
        
        if(null == keyword || "".equals(keyword)) {
            parts = new ArrayList<Part>();
        } else {
            parts = PartRepository.getInstance()
                .searchByPartName(keyword);
        }
        
        List<PartBean> partBeans = new ArrayList<PartBean>();
        
        for(Part part: parts) {
            PartBean partBean = new PartBean();       
            partBean.setPart(part);            
            partBeans.add(partBean);
        }
        
        return partBeans;
    }    
}
