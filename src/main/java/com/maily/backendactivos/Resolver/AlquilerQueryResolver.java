package com.maily.backendactivos.Resolver;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import com.maily.backendactivos.Model.Alquiler;
import com.maily.backendactivos.Model.AlquilerPage;
import com.maily.backendactivos.Model.PageInfo;
import com.maily.backendactivos.Repository.AlquilerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
 @Component @RestController
public class AlquilerQueryResolver implements GraphQLQueryResolver {
	
    @Autowired
    private AlquilerRepository alquilerRepository;
    @QueryMapping 
    public AlquilerPage getAllAlquileres(@Argument int page,@Argument int size) {
    	 Pageable pageable = PageRequest.of(page, size);
    	 Page<Alquiler> alquilerPage = alquilerRepository.findAll(pageable);
    	 PageInfo pageInfo = new PageInfo(alquilerPage.getTotalPages(), alquilerPage.getTotalElements(), page, size);
    	 return new AlquilerPage(pageInfo, alquilerPage.getContent());
    }
    
    @QueryMapping 
    public List<Alquiler> getAlquilers() {
        return alquilerRepository.findAll();
    }
}