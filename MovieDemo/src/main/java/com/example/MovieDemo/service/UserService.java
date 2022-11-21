package com.example.MovieDemo.service;

import com.example.MovieDemo.domain.Movie;
import com.example.MovieDemo.domain.User;
import com.example.MovieDemo.exception.UserAlreadyExist;
import com.example.MovieDemo.exception.UserNotFoundException;

public interface UserService {
    User addUser(User user) throws UserAlreadyExist;

    User addMovieForUser(String email, Movie movie) throws UserNotFoundException;

}
