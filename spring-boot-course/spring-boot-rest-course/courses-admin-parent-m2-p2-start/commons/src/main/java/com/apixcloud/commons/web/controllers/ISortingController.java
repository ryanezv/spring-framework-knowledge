package com.apixcloud.commons.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.apixcloud.commons.persistence.model.IEntity;

public interface ISortingController<T extends IEntity> {

    public Page<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    public Page<T> findAllPaginated(final int page, final int size);

    public Page<T> findAllSorted(final String sortBy, final String sortOrder);

    public List<T> findAll(final HttpServletRequest request);

}
