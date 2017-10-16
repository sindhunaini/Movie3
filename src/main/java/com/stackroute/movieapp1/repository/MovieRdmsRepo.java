package com.stackroute.movieapp1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movieapp1.model.MovieModel;
@Repository
public interface MovieRdmsRepo extends CrudRepository<MovieModel,String> {

	
}
