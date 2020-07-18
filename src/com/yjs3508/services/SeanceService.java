package com.yjs3508.services;

import com.yjs3508.dal.GenericDAO;
import com.yjs3508.dal.SeanceDAOImpl;
import com.yjs3508.model.domain.Seance;

public class SeanceService extends AbstractService<Seance> {

    public SeanceService() {
        super(new SeanceDAOImpl());
    }
}
