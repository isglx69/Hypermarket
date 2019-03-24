package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Client;
import java.util.List;

public interface ClientService {
    public Client addClient(Client client, boolean useHibernate);
    public Client getClientById(Long id);
    public List<Client> getAllClients();
    public Client updateClient(Client client);
    public void deleteClient(Client client);
}
