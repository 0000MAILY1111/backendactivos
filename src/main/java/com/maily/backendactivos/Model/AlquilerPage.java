package com.maily.backendactivos.Model;

import java.util.List;

public class AlquilerPage {
    private PageInfo pageInfo;
    private List<Alquiler> alquileres;

    public AlquilerPage(PageInfo pageInfo, List<Alquiler> alquileres) {
        this.pageInfo = pageInfo;
        this.alquileres = alquileres;
    }

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

    
}
