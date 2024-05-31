package com.apixcloud.courses.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apixcloud.commons.utils.QueryConstants;
import com.apixcloud.commons.web.controllers.AbstractController;
import com.apixcloud.commons.web.controllers.ISortingController;
import com.apixcloud.commons.web.exceptions.GenericResponseError;
import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.services.IUserService;
import com.apixcloud.courses.utils.UmMappings;
import com.apixcloud.courses.utils.UsersUtil.Privileges;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = UmMappings.USERS)
public class UserController extends AbstractController<User> implements ISortingController<User> {

    @Autowired
    private IUserService service;

    // find - all paginated, ordered or both

    @Override
    @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY }, method = RequestMethod.GET)    
    @Operation(summary = "Find all users paginated and sorted",
        parameters = {
            @Parameter(name = QueryConstants.PAGE, required = true),
            @Parameter(name = QueryConstants.SIZE, required = true),
            @Parameter(name = QueryConstants.SORT_BY, required = true)            
        })
    public List<User> findAllPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page, @RequestParam(value = QueryConstants.SIZE) final int size, @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
        @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
    }

    @Override
    @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE }, method = RequestMethod.GET)        
    @Operation(summary = "Find all users paginated and size",
        parameters = {
            @Parameter(name = QueryConstants.PAGE, required = true),
            @Parameter(name = QueryConstants.SIZE, required = true)
    })
    public List<User> findAllPaginated(@RequestParam(value = QueryConstants.PAGE) final int page, @RequestParam(value = QueryConstants.SIZE) final int size) {
        return findPaginatedInternal(page, size);
    }

    @Override
    @RequestMapping(params = { QueryConstants.SORT_BY }, method = RequestMethod.GET)
    @Operation(summary = "Find all users by sorted",
        parameters = {            
            @Parameter(name = QueryConstants.SORT_BY, required = true)
    })
    public List<User> findAllSorted(@RequestParam(value = QueryConstants.SORT_BY) final String sortBy, @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        return findAllSortedInternal(sortBy, sortOrder);
    }

    // find - all

    @Override    
    @RequestMapping(method = RequestMethod.GET)
    @Operation(summary = "Find all users")
    public List<User> findAll(final HttpServletRequest request) {
        return findAllInternal(request);
    }

    // find - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Operation(summary = "Find all users by sorted",
        parameters = {            
            @Parameter(name = "id", required = true),
            @Parameter(name = "Accept", description = "Accept header", required = true, in = ParameterIn.HEADER, schema = @Schema(type = "string", defaultValue = "application/json"))
    })
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "OK", content = 
                @Content(mediaType = "application/json", schema = 
                    @Schema(implementation = User.class))
            )
    })
    public User findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    // create

    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus(HttpStatus.CREATED)
    @Secured(Privileges.CAN_ROLE_WRITE)
    @Operation(summary = "Create new user")    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = { @Content( mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content( mediaType = "application/json", schema = @Schema(implementation = GenericResponseError.class)) }),
        @ApiResponse(
            responseCode = "404", 
            description = "Not Found", 
            content = @Content(
                mediaType = "application/json", 
                schema = @Schema(implementation = GenericResponseError.class)
            )
        ),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = { @Content( mediaType = "application/json" ) }),
        @ApiResponse(responseCode = "403", description = "Forbidden", content = { @Content( mediaType = "application/json", schema = @Schema(implementation = GenericResponseError.class)) }),
        @ApiResponse(responseCode = "409", description = "Conflic", content = { @Content( mediaType = "application/json", schema = @Schema(implementation = GenericResponseError.class)) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content( mediaType = "application/json", schema = @Schema(implementation = GenericResponseError.class)) })
    })
    public void create(@RequestBody @Valid final User resource) {
        createInternal(resource);
    }

    // update

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @Secured(Privileges.CAN_ROLE_WRITE) 
    public void update(@PathVariable("id") final Long id, @RequestBody final @Valid User resource) {
        updateInternal(id, resource); 
        
    }

    // delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured(Privileges.CAN_ROLE_WRITE) 
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }

    /* Spring */

    @Override
    protected final IUserService getService() {
        return service;
    }

}
