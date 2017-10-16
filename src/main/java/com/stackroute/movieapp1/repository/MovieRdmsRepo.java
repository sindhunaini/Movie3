package com.stackroute.movieapp1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movieapp1.model.MovieModel;
import java.lang.String;
import java.util.List;
@Repository
public interface MovieRdmsRepo extends CrudRepository<MovieModel,String> {

	MovieModel findById(String id);
}
