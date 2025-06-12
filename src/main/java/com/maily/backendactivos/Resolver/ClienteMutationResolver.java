package com.maily.backendactivos.Resolver;

import com.maily.backendactivos.Model.Cliente;
import com.maily.backendactivos.Repository.ClienteRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;



@Component @RestController
public class ClienteMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private ClienteRepository clienteRepository;


    @MutationMapping 
    public Cliente createCliente(@Argument String nombre, @Argument String cedula, @Argument String celular
    		, @Argument String fechaNacimiento, @Argument String direccion) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setCelular(celular);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setDireccion(direccion);
        return clienteRepository.save(cliente);
    
    }

    @MutationMapping
    public boolean deleteCliente(@Argument Long clienteId) {
    	if (clienteRepository.existsById(clienteId)) {
            clienteRepository.deleteById(clienteId);
            return true;
        } else {
            return false;
        }
    }
  
}
