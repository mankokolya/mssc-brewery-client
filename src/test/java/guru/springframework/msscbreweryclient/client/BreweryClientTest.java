package guru.springframework.msscbreweryclient.client;

import guru.springframework.msscbreweryclient.web.client.BreweryClient;
import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        URI uri = breweryClient.saveNewBeer(BeerDto.builder().beerName("New Beer").build());
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteDeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        URI uri = breweryClient.saveNewCustomer(CustomerDto.builder().name("Customer").build());
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}
