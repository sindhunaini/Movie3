

import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.context.embedded.LocalServerPort;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;

import com.stackroute.movieapp1.MainClass;

//import com.stackroute.movieapp1.model;

import com.stackroute.movieapp1.model.MovieModel;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = MainClass.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class Testfile {

   String user1;

    @LocalServerPort

    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    MovieModel movieModel;

    @Before

    public void setUp() throws Exception {

       movieModel = new MovieModel("1","Paul Dawson","tata");

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

      assertEquals("New data is created",actual);

    
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
}
           
    

   /* 

    @Test

    public void testread() throws Exception {

      HttpEntity<String> entity = new HttpEntity<String>(null, headers);

      ResponseEntity<String> response = restTemplate.exchange(

          createURLWithPort("/v0.1/MovieService/Movies"),

          HttpMethod.GET, entity, String.class);

      assertNotNull(response);

    }

    

    @Test

    public void testAddRestaurant() throws Exception {

      HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(restaurant, headers);

      ResponseEntity<String> response = restTemplate.exchange(

          createURLWithPort("v1.0/restaurantservice/restaurant"),

          HttpMethod.POST, entity, String.class);

      assertNotNull(response);

      String actual = response.getBody();

      System.out.println(actual);

      assertEquals("Done",actual);

    }

    @Test

    public void read() throws Exception {

      HttpEntity<String> entity = new HttpEntity<String>(null, headers);

      ResponseEntity<String> response = restTemplate.exchange(

          createURLWithPort("/user/list"),

          HttpMethod.GET, entity, String.class);

      assertNotNull(response);

    }

    @Test

    public void update() throws Exception {

    }

    @Test

    public void delete() throws Exception {

    }
    
    
    */