package com.yjs3508.services;

import com.yjs3508.dal.ActorDAOImpl;
import com.yjs3508.model.domain.Actor;

public class ActorService extends  AbstractService<Actor>{

    public ActorService() {
        super(new ActorDAOImpl());
    }

}
