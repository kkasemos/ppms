/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.repository;

import com.logindy.ppms.entity.Part;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author krit
 */
public class PartRepository {
    
    private static PartRepository repository;
    private List<Part> parts;
    
    private PartRepository() {
        parts = new ArrayList<Part>();
    }
    
    public static PartRepository getInstance() {
        
        if(null == repository) {
            repository = new PartRepository();
            repository.add(new Part("Part A"));
            repository.add(new Part("Part B"));
        } 
        
        return repository;
    }

    public List<Part> searchByPartName(String name) {
        return search("name", name);
    }
    
    public List<Part> search(String fieldName, String keyword) {

        List<Part> results = new ArrayList<Part>();
        Comparator comparator = getComparator(fieldName);
        
        for(Part part: parts) {            
            if(0 == comparator.compare(part, keyword)) {
                results.add(part);
            }
        }
        
        return results;
        
    }

    private void add(Part part) {
        parts.add(part);
    }

    private Comparator getComparator(String fieldName) {
        return new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                Part part = (Part)o1;
                String name = (String)o2;
                
                if(-1 != part.getName().indexOf(name)) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
    }    
}
