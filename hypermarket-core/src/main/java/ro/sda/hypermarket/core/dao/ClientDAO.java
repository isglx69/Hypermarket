package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

public interface ClientDAO {
    public Client addClient( Client client);
    public Client getClientById(Long id);
    public List<Client> getAllClients();
    public Client updateClient (Client client);
    public void deleteClient(Client client);
}


