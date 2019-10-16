package com.pc.service.impl;

import com.pc.dao.UserDAO;
import com.pc.entity.User;
import com.pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserDAO userDAO;
    @Override
    @Transactional(readOnly = true)
    public User selectByName(String name) {
        User user = userDAO.selectByName(name);
        return user;
    }
}
