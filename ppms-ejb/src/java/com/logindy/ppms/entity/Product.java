/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krit
 */
public class Product {
    private String name;
    private List<PartModel> partModels;
    
    public Product(String name) {
        this.name = name;
        this.partModels = new ArrayList<PartModel>();
    }

    public Product(String name, PartModel partModel) {
        this(name);
        partModels.add(partModel);
    }

    public PartModel getPartModel(int partNo) {
        return partModels.get(partNo);
    }
    
    public void addPartModel(PartModel partModel) {
        partModels.add(partModel);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
