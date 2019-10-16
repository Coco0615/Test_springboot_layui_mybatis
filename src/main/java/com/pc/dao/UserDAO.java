package com.pc.dao;

import com.pc.entity.User;

public interface UserDAO {
    User selectByName(String name);
}
