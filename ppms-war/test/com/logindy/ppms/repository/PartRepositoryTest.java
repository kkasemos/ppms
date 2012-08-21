/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logindy.ppms.repository;

import com.logindy.ppms.entity.Part;
import com.logindy.ppms.web.bean.PartBean;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krit
 */
public class PartRepositoryTest {
    
    PartRepository partRepo;
            
    public PartRepositoryTest() {
    }
    
    @Before
    public void setUp() {
        partRepo = PartRepository.getInstance();        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test_searchByPartName_PartA_Found() {
        List<Part> parts = partRepo.searchByPartName("Part A");

        Assert.assertEquals(1, parts.size());
        
        Part part = parts.get(0);
        Assert.assertEquals("Part A", part.getName());
    }
    
    @Test
    public void test_searchByPartName_PartB_Found() {
        List<Part> parts = partRepo.searchByPartName("Part B");

        Assert.assertEquals(1, parts.size());
        
        Part part = parts.get(0);
        Assert.assertEquals("Part B", part.getName());
    }

    @Test
    public void test_searchByPartName_InvalidPart_NotFound() {
        List<Part> parts = partRepo.searchByPartName("InvalidPart");

        Assert.assertEquals(0, parts.size());
    }    
}
