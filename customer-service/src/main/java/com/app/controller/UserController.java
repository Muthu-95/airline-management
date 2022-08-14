package com.app.controller;

import com.app.dto.UserDto;
import com.app.model.Users;
import com.app.service.UserService;
import com.app.util.Constants;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    JSONObject json = new JSONObject();

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<JSONObject> createUser(UserDto inputParameters) throws JSONException {
        int tempId = userService.createUser(inputParameters);
        if (tempId > 0)
            return new ResponseEntity<>(json.put(Constants.MSG,Constants.USER_CREATED_SUCCESSFULLY), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(json.put(Constants.MSG,Constants.FAILED_TO_CREATED_USER), HttpStatus.FAILED_DEPENDENCY);
    }

    @GetMapping("/getAllUsers")
    public Users getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/updateCustomerDetails/{userId}/{mobileNumber}")
    public String updateCustomerDetails(@PathVariable ("userId") int userId,
                                        @PathVariable ("mobileNumber") String mobileNumber){
        boolean isUpdated = userService.updateCustomerDetails(userId, mobileNumber);
        if (isUpdated)
            return "Details updated successfully";
        else
            return "Failed to update";
    }

    @DeleteMapping("/deleteCustomerDetails/{userId}")
    public String deleteCustomerDetails (@PathVariable ("userId") int userId) {
        boolean isDeleted = userService.deleteCustomerDetails(userId);
        if (isDeleted)
            return "Account deleted successfully";
        else
            return "Failed to delete";
    }

}
