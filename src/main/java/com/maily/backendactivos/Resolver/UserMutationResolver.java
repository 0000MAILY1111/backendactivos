package com.maily.backendactivos.Resolver;


import com.maily.backendactivos.Exception.DuplicateEntryException;
import com.maily.backendactivos.Exception.EntityNotFoundException;
import com.maily.backendactivos.Repository.UserRepository;
import com.maily.backendactivos.Model.User;


import graphql.kickstart.tools.GraphQLMutationResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;




@Component @RestController

public class UserMutationResolver implements GraphQLMutationResolver {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @MutationMapping 
    public User createUser(@Argument User user) {
    	if(!userRepository.existsByEmail(user.getEmail())) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(User.Role.NORMAL);
        }
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntryException("Error, Email ya existe!");
        }
    	}else {
    		 throw new DuplicateEntryException("Error2, Email ya existe!");
    	}
    	
    }

    public User updateUser(User updateRequest) {
        if (updateRequest.getId() == null) {
            throw new IllegalArgumentException("The update request must include an ID");
        }
        if (updateRequest.getUsername() == null && updateRequest.getPassword() == null && updateRequest.getRole() == null) {
            throw new IllegalArgumentException("The update request must include values for either" +
                    "the username, password or role");
        }

        LOGGER.info("Update request received: {}", updateRequest);

        User currentUser = userRepository.findById(updateRequest.getId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        currentUser.merge(updateRequest);

        return userRepository.save(currentUser);
    }
    @MutationMapping 
    public boolean deleteUser(@Argument Long id) {
        LOGGER.info("Received request to delete user with id: {}", id);
        userRepository.deleteById(id);

        return true;
    }
}
