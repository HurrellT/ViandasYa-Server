package app.api.user;

import app.model.User.Client.Client;
import app.model.User.Provider.Provider;
import app.model.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends CrudRepository<User, Long>,
                PagingAndSortingRepository<User, Long> {

    User findByName(String name);

    Client findClientById(Long id);

    Provider findProviderById(Long id);

    Client findByType(String type);

    Client findClientByEmail(String email);

    boolean existsByEmail(String email);

    User findUserByEmail(String email);

    //TODO: check to replace the save from spring to go through the class constructor
    //in order to check the validations, and if there's something wrong, send a bad request

}

