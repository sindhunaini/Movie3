package com.stackroute.movieapp1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieapp1.Getservice.MovieService;
import com.stackroute.movieapp1.Getservice.dbMovieService;
import com.stackroute.movieapp1.model.MovieModel;



@RestController
@RequestMapping("/v1.0/topicservice")
public class MovieController {

    @Autowired
   private MovieService movieService;

  //  @RequestMapping(method=RequestMethod.GET, value="/movies") 
    @GetMapping("/hackathon")
   public ResponseEntity getAllMovies( )
   {
    	System.out.println("hiiiii");
    	
      List<MovieModel> resultList1 = movieService.getAllMovie();
       
       return new ResponseEntity<List<MovieModel>>(resultList1, HttpStatus.OK) ;
   }
    
    @RequestMapping(method=RequestMethod.POST, value="/hackathon", consumes="application/json")
   public ResponseEntity addTopic(@RequestBody MovieModel movie)
   {
       /*Add validation code*/        
        movieService.add(movie);
       return new ResponseEntity<String>("New data is created", HttpStatus.OK) ;
       
   }
    @RequestMapping(method=RequestMethod.DELETE, value="/hackathon/delete/{id}", consumes="application/json")
    public ResponseEntity<String> delete(@PathVariable("id") String  id)
    {
        /*Add validation code*/        
         movieService.delete(id);
        return new ResponseEntity<String>("Deleted succesfully", HttpStatus.OK) ;
        
    }
//    
//    @PutMapping("/data")
//    public @ResponseBody ResponseEntity<String> putPerson(RequestEntity<MovieModel> request) {
//      System.out.println("hey bro");
//      MovieService.update(request);
//      return new ResponseEntity<String>("Response from PUT", HttpStatus.OK);
//    }
  
    @RequestMapping(method=RequestMethod.PUT, value="/hackathon/update", consumes="application/json")
    public ResponseEntity updateTopic(@RequestBody MovieModel movie)
    {
        /*Add validation code*/        
         movieService.update(movie);
        return new ResponseEntity<String>("User updated successfully", HttpStatus.OK) ;
        
    }
	
    
    
    
    
    
    
//    @RequestMapping(method=RequestMethod.PUT, value="/movies/put",consumes="application/json")
//    public @ResponseBody ResponseEntity<String> putPerson(RequestEntity<MovieModel> request) {
//      System.out.println("hey bro");
//      movieService.update(request);
//      return new ResponseEntity<String>("Response from PUT", HttpStatus.OK);
//    }
    

}