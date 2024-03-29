package sb.tutorial.myapp.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.tutorial.myapp.exception.UserNotFoundException;
import sb.tutorial.myapp.model.User;
import sb.tutorial.myapp.model.dto.UserDto;
import sb.tutorial.myapp.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }


    public UserDto deleteUserById(String id) {
        log.info("deleteUserById ENTERTED");
        try {
            if (log.isDebugEnabled()) {
                log.debug("entered user id is : " + id);
            }
            if (userRepository.findById(id).isPresent()) {
                User userEntity = userRepository.deleteUserById(id);
                UserDto resp = new UserDto();
                resp.setUserId(userEntity.getId());
                resp.setUserName(userEntity.getName());
                resp.setAge(userEntity.getAge());
                resp.setResponseMsg("Record successfully deleted!");
                return resp;
            } else {
                throw new UserNotFoundException("User with given ID:" + id + " not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String createUser(User user) {
        log.info("Request to create user has started!");
        userRepository.save(user);
        return "User with id:" + user.getId() + " is created";
    }

    public String updateUser(User user) {
        log.info("Request to update user has started!");
        userRepository.save(user);
        return "User with id:" + user.getId() + " is updated";
    }


}
