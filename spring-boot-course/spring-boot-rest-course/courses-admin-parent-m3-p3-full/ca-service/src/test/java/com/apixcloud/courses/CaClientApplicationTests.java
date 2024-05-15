package com.apixcloud.courses;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.security.ITestAuthenticator;
import com.apixcloud.courses.spring.UsersApp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(classes = UsersApp.class)
public class CaClientApplicationTests {

  @Autowired
  private ITestAuthenticator auth;

  private final static String URI = "http://localhost:8080/api/roles";
  
  @Test
  void authentication_then200IsRecieved_andGetRoles() {
    
    // When
    final Response response = givenAuthenticated().contentType(APPLICATION_JSON.toString())
    .get(URI);

    // Then
    assertThat(response.getStatusCode(), is(200));
  }

  @Test
  public final void whenAuthenticationIsPerformed_thenResponseIsUser__andGetRoles() {
      // When
      final Response response = givenAuthenticated().contentType(APPLICATION_JSON.toString())
          .get(URI);

      System.out.println(URI);
      // Then
      response.as(User.class);      
  }

  protected RequestSpecification givenAuthenticated() {
    return auth.givenAuthenticated("admin", "admin123");
}
}