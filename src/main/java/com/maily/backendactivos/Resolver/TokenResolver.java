package com.maily.backendactivos.Resolver;

import com.maily.backendactivos.Repository.UserRepository;
import com.maily.backendactivos.Security.TokenGenerator;
import com.maily.backendactivos.Model.User;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@Component @RestController
public class TokenResolver implements GraphQLMutationResolver {
 

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @MutationMapping 
    public String getToken(@Argument String email,@Argument String password) {
        User user = userRepository.findByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new GraphQLException("Invalid credentials");
        }

        return tokenGenerator.build(user.getUsername(), user.getRole());
    }


}