package ro.sda.hypermarket.core.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDAO;
import ro.sda.hypermarket.core.repository.ClientRepository;
import ro.sda.hypermarket.core.entity.Client;

import java.util.List;


@Service("clientService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Client addClient(Client client, boolean useHibernate) {
        if(useHibernate) {
            return clientDAO.addClient(client);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return getCurrentSession().load(Client.class, id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    public Client updateClient(Client client) {
        return clientDAO.updateClient(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientDAO.deleteClient(client);
    }
}

