package com.apixcloud.commons.persistence.service;

import com.apixcloud.commons.interfaces.IByNameApi;
import com.apixcloud.commons.interfaces.IWithName;

public interface IService<T extends IWithName> extends IRawService<T>, IByNameApi<T> {

    //

}
