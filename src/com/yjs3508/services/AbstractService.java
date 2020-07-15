package com.yjs3508.services;

import com.yjs3508.dal.GenericDAO;

import java.util.List;

public abstract class AbstractService<E> {

    private GenericDAO<E> dao;

    public AbstractService(GenericDAO<E> dao) {
        this.dao = dao;
    }

    public E save(E entity){
        return dao.save(entity);
    }

    public List<E> getAll(){
        return dao.getAll();
    }

}
