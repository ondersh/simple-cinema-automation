package com.yjs3508.services;

import com.yjs3508.dal.DirectorDAOImpl;
import com.yjs3508.model.domain.Director;

public class DirectorService extends AbstractService<Director> {
    public DirectorService() {
        super(new DirectorDAOImpl());
    }
}
