package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

public interface ClientDAO {
    Session getCurrentSession();
    Client getbyId(Long id);
    List<Client> getAll();
    Client createClient( Client client);
    Client updateClient (Client client);
    void deleteClient(Client client);
}


