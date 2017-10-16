

import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.context.embedded.LocalServerPort;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;

import com.stackroute.movieapp1.MainClass;

import com.stackroute.movieapp1.Getservice.MovieService;

//import com.stackroute.movieapp1.model;

import com.stackroute.movieapp1.model.MovieModel;

import com.stackroute.movieapp1.repository.MovieRdmsRepo;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = MainClass.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class Testfile {

  

 private MovieModel moviemodel;

//  String user1;

  @LocalServerPort

  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  MovieModel movieModel;

  @Before

  public void setUp() throws Exception {

    movieModel = new MovieModel("5","Paul Dawson","tata");

  }

  private String createURLWithPort(String uri) {

   return "http://localhost:" + port + uri;

  }

  @After

  public void tearDown() throws Exception {

  }

  @Test

  public void Testcreate() throws Exception {

   HttpEntity<MovieModel> entity = new HttpEntity<MovieModel>(movieModel, headers);

   ResponseEntity<String> response = restTemplate.exchange(

     createURLWithPort("/v1.0/topicservice/hackathon"),

     HttpMethod.POST, entity, String.class);

   assertNotNull(response);

   String actual = response.getBody();

   System.out.println(actual);

   assertEquals("data already exists",actual);

  

  }

  @Test

  public void testSaveUser() throws Exception {

    HttpEntity<MovieModel> entity = new HttpEntity<MovieModel>(movieModel, headers);

    ResponseEntity<String> response = restTemplate.exchange(

        createURLWithPort("/v1.0/topicservice/hackathon/update"),

        HttpMethod.PUT, entity, String.class);

    assertNotNull(response);

    String set = response.getBody();

    System.out.println(set);

    assertEquals("User updated successfully",set);

  }

  @Test

  public void testdelete() throws Exception {

    HttpEntity<MovieModel> entity = new HttpEntity<MovieModel>(movieModel, headers);

    ResponseEntity<String> response = restTemplate.exchange(

        createURLWithPort("/v1.0/topicservice//hackathon/delete/2"),

        HttpMethod.DELETE, entity, String.class);

    assertNotNull(response);

    String actual = response.getBody();

    System.out.println(actual);

    assertEquals("Deleted succesfully",actual);
  }
  @Test
  public void testupdate() throws Exception {

      HttpEntity<MovieModel> entity = new HttpEntity<MovieModel>(movieModel, headers);
      ResponseEntity<String> response = restTemplate.exchange(
              createURLWithPort("/v1.0/topicservice/hackathon/update"),
              HttpMethod.PUT, entity, String.class);
      assertNotNull(response);
      String actual = response.getBody();
      System.out.println(actual);
      assertEquals("User updated successfully",actual);
  }  
  }  

 