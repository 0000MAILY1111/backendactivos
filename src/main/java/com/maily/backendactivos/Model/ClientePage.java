package com.maily.backendactivos.Model;

import java.util.List;

public class ClientePage {
    private PageInfo pageInfo;
    private List<Cliente> clientes;

    public ClientePage(PageInfo pageInfo, List<Cliente> clientes) {
        this.pageInfo = pageInfo;
        this.clientes = clientes;
    }

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

    
}
