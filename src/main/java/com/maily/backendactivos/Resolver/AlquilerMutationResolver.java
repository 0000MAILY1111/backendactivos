package com.maily.backendactivos.Resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.maily.backendactivos.Model.Activo;
import com.maily.backendactivos.Model.ActivoInput;
import com.maily.backendactivos.Model.Alquiler;
import com.maily.backendactivos.Model.Categoria;
import com.maily.backendactivos.Model.Cliente;
import com.maily.backendactivos.Repository.AlquilerRepository;
import com.maily.backendactivos.Repository.ClienteRepository;

@Component @RestController
public class AlquilerMutationResolver implements GraphQLMutationResolver {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @MutationMapping
    public Alquiler createAlquiler(
            @Argument long clienteId,
            @Argument ActivoInput activoInput,
            @Argument String fechaInicio,
            @Argument String fechaFin,
            @Argument String monto,
            @Argument String descripcion) {

        Cliente cliente = clienteRepository.findByClienteId(clienteId);

        Activo activo = new Activo();
        activo.set_id(activoInput.get_id());
        activo.setNombre(activoInput.getNombre());
        activo.setDescripcion(activoInput.getDescripcion());
        activo.setCategoria(new Categoria(activoInput.getCategoria().get_id(), activoInput.getCategoria().getNombre(), activoInput.getCategoria().getDescripcion()));
        activo.setFechaAdquisicion(activoInput.getFechaAdquisicion());
        activo.setPrecio(activoInput.getPrecio());
        activo.setEstado(activoInput.getEstado());
        Alquiler alquiler = new Alquiler(cliente, activo, fechaInicio, fechaFin, monto, descripcion);

        return alquilerRepository.save(alquiler);
    }

    @MutationMapping 
    public boolean deleteAlquiler(@Argument Long alquilerId) {
        LOGGER.info("Received request to delete user with id: {}", alquilerId);
        alquilerRepository.deleteById(alquilerId);

        return true;
    }
}
