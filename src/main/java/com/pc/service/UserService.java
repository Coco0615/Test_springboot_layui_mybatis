package com.pc.service;

import com.pc.entity.User;

public interface UserService {
    User selectByName(String name);
}
