package com.picpay.pagamentos.services;

import com.picpay.pagamentos.domain.User;
import com.picpay.pagamentos.dto.UserDTO;
import com.picpay.pagamentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO user){
        User newUser = new User();

        newUser.setFirstName(user.firstName());
        newUser.setLastName(user.lastName());
        newUser.setDocument(user.document());
        newUser.setEmail(user.email());
        newUser.setPassword(user.password());
        newUser.setType(user.type());
        newUser.setAmount(user.amount());

       return userRepository.save(newUser);
    }

    public Optional<User> findUserByDocument(String document) throws Exception {
       if(document == null){
           throw new Exception("documento não encontrado");
       }
        return userRepository.findUserByDocument(document);
    }

    public Optional<User> findUserById(Long id) throws Exception {
        if(id == null){
            throw new Exception("id não encontrado");
        }
        return userRepository.findById(id);
    }
}
