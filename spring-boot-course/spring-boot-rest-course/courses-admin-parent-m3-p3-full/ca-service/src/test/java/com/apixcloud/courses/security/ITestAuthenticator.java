package com.apixcloud.courses.security;

import io.restassured.specification.RequestSpecification;

public interface ITestAuthenticator {

    RequestSpecification givenAuthenticated(final String username, final String password);

}
