package es.upm.miw.innoassessment.data.entities;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import es.upm.miw.innoassessment.data.entities.Product;

public class ProductTest {

    @Test
    public void testProduct() {
    	Product product = new Product("test","v0","demo provider","test product") ;       
        assertTrue(product.getName() == "test");
    }

    

   
       

}
