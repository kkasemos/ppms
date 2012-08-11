/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.entity;

/**
 *
 * @author krit
 */
public class PartModel {
    private final String modelName;
    private final Part part;

    public PartModel(String partName, String modelName) {
        this.part = new Part(partName);
        this.modelName = modelName;
    }

    public String getPartName() {
        return part.getName();
    }

    public String getModelName() {
        return modelName;
    }

    void setPartName(String name) {

    }
    
}
