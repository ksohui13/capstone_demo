package com.esg.esgProject.service.lmpl;

import com.esg.esgProject.dao.UserDao;
import com.esg.esgProject.domain.User;
import com.esg.esgProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService {
    private final UserDao userDao;
    @Override
    public List<User> getUsers() throws ExecutionException, InterruptedException {
        return userDao.getUsers();
    }
}
