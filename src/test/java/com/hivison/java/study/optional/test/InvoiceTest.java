package com.hivison.java.study.optional.test;

import com.hivison.java.study.optional.Invoice;
import com.hivison.java.study.optional.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class InvoiceTest {

    private Invoice invoice;

    @Before
    public void initializer(){
        invoice = new Invoice();
    }

    @Test
    public void should_recovery_all_products_ids_of_invoices() throws Exception{
        invoice.addProduct(new Product(1L, "Soap"))
                .addProduct(new Product(2L, "Toothpaste"))
                .addProduct(new Product(3L,"Deodorant"));

        final List<Long> productsIds = invoice.getProductsIds();

        assertThat(productsIds, hasItems(1L, 2L, 3L));
    }
}
