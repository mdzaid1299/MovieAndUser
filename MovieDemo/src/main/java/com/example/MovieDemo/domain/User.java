package com.example.MovieDemo.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {
    private int userId;
    private List<Movie> movieList;
    @Id
    private String email;
    private String userName;
    private String address;
    private long mobileNo;

    private User() {
    }

    public User(int userId, List<Movie> movieList, String email, String userName, String address, long mobileNo) {
        this.userId = userId;
        this.movieList = movieList;
        this.email = email;
        this.userName = userName;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", movieList=" + movieList +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
