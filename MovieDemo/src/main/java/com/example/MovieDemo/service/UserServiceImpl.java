package com.example.MovieDemo.service;

import com.example.MovieDemo.domain.Movie;
import com.example.MovieDemo.domain.User;
import com.example.MovieDemo.exception.UserAlreadyExist;
import com.example.MovieDemo.exception.UserNotFoundException;
import com.example.MovieDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExist {
        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExist();
        }
        return userRepository.insert(user);
    }

    @Override
    public User addMovieForUser(String email, Movie movie) throws UserNotFoundException {
        if (userRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = userRepository.findByEmail(email);
        if (user.getMovieList() == null) {
            user.setMovieList(Collections.singletonList(movie));

        } else {
            List<Movie> movies = user.getMovieList();
            movies.add(movie);
            user.setMovieList(movies);
        }
        return userRepository.save(user);
    }
}
