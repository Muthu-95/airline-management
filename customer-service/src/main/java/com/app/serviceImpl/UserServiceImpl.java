package com.app.serviceImpl;

import com.app.exception.ApplicationException;
import com.app.exception.ErrorCode;
import com.app.model.Users;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users getAllUsers() {
        Users users = null;
        try {
            users = userRepository.findAllUsers();
            if (users == null)
                throw new ApplicationException(ErrorCode.USER_DETAILS_NOTFOUND);
        } catch (ApplicationException e) {
            throw new ApplicationException(ErrorCode.USER_DETAILS_NOTFOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
