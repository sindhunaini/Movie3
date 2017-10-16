package com.stackroute.movieapp1.Getservice;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.stackroute.movieapp1.model.MovieModel;

@Service
public interface MovieService {

	  public List<MovieModel> getAllMovie();
	  public  MovieModel add(MovieModel moviesmodel);
	  public String  delete(String id);
	  public  MovieModel update(MovieModel moviesmodel);
	  public MovieModel getMovie(String id);
	  public MovieModel findById(String id);
	  
	 }
