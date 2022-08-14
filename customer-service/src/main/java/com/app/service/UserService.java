package com.app.service;

import com.app.dto.UserDto;
import com.app.model.Users;

public interface UserService {
    Users getAllUsers();
    int createUser(UserDto inputParameters);
    boolean updateCustomerDetails(int userId, String mobileNumber);
    boolean deleteCustomerDetails(int userId);
}
