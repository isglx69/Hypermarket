package ro.sda.hypermarket.core.entity.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.service.ClientService;
import java.util.List;

public class ClientServiceTest {
    @Autowired
    private ClientService clientService;

    @Test
    @Rollback(false)
    public void testAddClient() {
        Client client = new Client();
        client.setName("Cristi");
        clientService.addClient(client, false);

        Client client2 = new Client();
        client.setName("Vasile");
        clientService.addClient(client, false);
    }

    @Test
    public void getAllClients() {
        List<Client> allClients = clientService.getAllClients();
        System.out.println(allClients);
    }

    @Test
    public void testDeleteClient() {
        Long foundId = 5L;
        Client client = clientService.getClientById(foundId);
        clientService.deleteClient(client);
    }

    @Test
    public void testUpdateSupplier() {
        Long foundId = 1L;
        Client client = clientService.getClientById(foundId);
        client.setName("Dorel");
        clientService.updateClient(client);
    }
}
