package com.apixcloud.commons.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.apixcloud.commons.interfaces.IWithName;
import com.apixcloud.commons.persistence.service.IRawService;
import com.apixcloud.commons.web.RestPreconditions;
import com.apixcloud.commons.web.exceptions.MyResourceNotFoundException;

public abstract class AbstractReadOnlyController<T extends IWithName> {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    // find - one

    protected final T findOneInternal(final Long id) {
        return RestPreconditions.checkNotNull(getService().findOne(id));
    }

    // find - all

    protected final List<T> findAllInternal(final HttpServletRequest request) {
        if (request.getParameterNames()
            .hasMoreElements()) {
            throw new MyResourceNotFoundException();
        }
        
        return getService().findAll();
    }

    protected final Page<T> findPaginatedAndSortedInternal(final int page, final int size, final String sortBy, final String sortOrder) {
        final Page<T> resultPage = getService().findAllPaginatedAndSortedRaw(page, size, sortBy, sortOrder);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }

        return resultPage;
    }

    protected final Page<T> findPaginatedInternal(final int page, final int size) {
        final Page<T> resultPage = getService().findAllPaginatedRaw(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }

        return resultPage;
    }

    protected final Page<T> findAllSortedInternal(final String sortBy, final String sortOrder) {
        final Page<T> resultPage = getService().findAllSorted(sortBy, sortOrder);
        return resultPage;
    }

    // count

    protected final long countInternal() {
        return getService().count();
    }

    // generic REST operations

    // count

    /**
     * Counts all {@link Privilege} resources in the system
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/count")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long count() {
        return countInternal();
    }

    // template method

    protected abstract IRawService<T> getService();

}
