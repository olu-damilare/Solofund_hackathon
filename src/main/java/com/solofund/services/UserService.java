package com.solofund.services;

import com.solofund.models.User;
import com.solofund.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> userOptional = userRepository.findUserBySSN(user.getSsn());
        if(userOptional.isPresent()) throw new IllegalStateException("user already exists");

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean userExists = userRepository.existsById(id);
        if(!userExists) throw new IllegalStateException("user with id " +
                id + " does not exist");
        userRepository.deleteById(id);
    }



}
