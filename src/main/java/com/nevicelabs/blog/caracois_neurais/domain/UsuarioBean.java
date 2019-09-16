package com.nevicelabs.blog.caracois_neurais.domain;

import javax.faces.bean.ManagedBean;
import com.nevicelabs.blog.caracois_neurais.persistence.UsuarioDAO;

@ManagedBean
public class UsuarioBean {
    private Usuario usuario;
    private UsuarioDAO dao;

    public void logar() {
        dao.logar();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }
}
