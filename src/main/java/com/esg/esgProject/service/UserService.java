package com.esg.esgProject.service;

import com.esg.esgProject.domain.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {
    List<User> getUsers() throws ExecutionException, InterruptedException;
}
