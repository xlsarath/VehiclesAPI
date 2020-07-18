package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@WebMvcTest(PriceRepository.class)
public class PriceRepoTest {

    @MockBean
    PriceRepository priceRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetPrice() throws PriceException {
        Price price = new PricingService().getPrice(1L);
        Assert.assertEquals(price.getCurrency(), "USD");
        Assert.assertTrue(price.getPrice().compareTo(new BigDecimal(3000))>=0);
        Assert.assertTrue(price.getPrice().compareTo(new BigDecimal(55000))<0);

    }

}