package sb.tutorial.myapp.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import sb.tutorial.myapp.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findUserByNameStartsWith(String id);

    User deleteUserById(String id);

}


