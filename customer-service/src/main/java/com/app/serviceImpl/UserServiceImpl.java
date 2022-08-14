package com.app.serviceImpl;

import com.app.dto.UserDto;
import com.app.exception.ApplicationException;
import com.app.exception.ErrorCode;
import com.app.model.Users;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int createUser(UserDto inputParameters) {
        int tempId = 0;
        Users userCheck = new Users();
        if (inputParameters.getRoleId() != 2)
            throw new ApplicationException(ErrorCode.INVALID_ROLE_ID);
        if (inputParameters.getFirstName() == null)
            throw new ApplicationException(ErrorCode.INVALID_FIRST_NAME);
        if (inputParameters.getLastName() == null)
            throw new ApplicationException(ErrorCode.INVALID_LAST_NAME);
        if (inputParameters.getPassword() == null)
            throw new ApplicationException(ErrorCode.INVALID_PASSWORD);
        if (inputParameters.getMobileNumber() == null)
            throw new ApplicationException(ErrorCode.INVALID_MOBILE_NUMBER);
        try {
            userCheck = userRepository.findUserByEmail(inputParameters.getEmail());
            if (userCheck != null)
                throw new ApplicationException(ErrorCode.USER_ALREADY_EXISTS);
            else {
                Users user = new Users();
                user.setRoleId(inputParameters.getRoleId());
                user.setFirstName(inputParameters.getFirstName());
                user.setLastName(inputParameters.getLastName());
                user.setEmail(inputParameters.getEmail());
                user.setPassword(inputParameters.getPassword());
                user.setMobileNumber(inputParameters.getMobileNumber());
                user.setIsDeleted(false);
                user.setCreatedOn(LocalDateTime.now());
                user.setModifiedOn(LocalDateTime.now());
                tempId = userRepository.save(user).getUserId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempId;
    }

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

    @Override
    public boolean updateCustomerDetails(int userId, String mobileNumber) {
        boolean isUpdated = false;
        Users user = new Users();
        if (mobileNumber == null)
            throw new ApplicationException(ErrorCode.INVALID_MOBILE_NUMBER);
        try {
            user = userRepository.findByUserId(userId);
            if (user == null)
                throw new ApplicationException(ErrorCode.USER_DETAILS_NOTFOUND);
            else {
                user.setMobileNumber(mobileNumber);
                String updatedNumber = userRepository.save(user).getMobileNumber();
                if (updatedNumber.equals(mobileNumber))
                    isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCustomerDetails(int userId) {
        boolean isDeleted = false;
        Users user = new Users();
        if (userId <= 0)
            throw new ApplicationException(ErrorCode.INVALID_USER_ID);
        try {
            user = userRepository.findByUserId(userId);
            if (user == null)
                throw new ApplicationException(ErrorCode.USER_DETAILS_NOTFOUND);
            else {
                user.setIsDeleted(true);
                boolean deleteStatus = userRepository.save(user).getIsDeleted();
                if (deleteStatus)
                    isDeleted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

}
