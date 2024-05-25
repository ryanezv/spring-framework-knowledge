package com.apixcloud.commons.web.controllers;

import com.apixcloud.commons.persistence.model.INameableEntity;
import com.apixcloud.commons.web.RestPreconditions;

public abstract class AbstractController<T extends INameableEntity> extends AbstractReadOnlyController<T> {

    // save/create/persist

    protected final void createInternal(final T resource) {
        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestState(resource.getId() == null);
        getService().create(resource);
    }

    // update

    protected final void updateInternal(final long id, final T resource) {        
        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestElementNotNull(resource.getId(), resource.getClass().getSimpleName() + " - El atributo id es obligatorio");        
        RestPreconditions.checkRequestState(resource.getId() == id, resource.getClass().getSimpleName() +" - El id request y id URI no coinciden.");
        RestPreconditions.checkNotNull(getService().findOne(resource.getId()), resource.getClass().getSimpleName() + " - El recurso no existe en la Base de Datos.");
      
        getService().update(resource);
    }

    // delete by id

    protected final void deleteByIdInternal(final long id) {
        getService().delete(id);
    }

}
