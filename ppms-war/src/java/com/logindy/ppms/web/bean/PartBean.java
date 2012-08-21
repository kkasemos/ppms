/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.web.bean;

import com.logindy.ppms.entity.Part;

/**
 *
 * @author krit
 */
public class PartBean {
    
    private Part part;

    public PartBean() {
    }    
    
    public PartBean(Part part) {
        this.part = part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    
    public String getName() {
        return this.part.getName();
    }
    
}
