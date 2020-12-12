package com.faisal.canteenapp.canteenapp.user;

import com.faisal.canteenapp.canteenapp.commonresponsemodel.ResponseModel;
import com.faisal.canteenapp.canteenapp.exceptionhandler.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userDaoService;

    //get all user
    @RequestMapping(method = RequestMethod.GET, path = "getusers")
    public ResponseModel getAllUser() {
        List<User> users = userDaoService.getAllUser();
        ResponseModel responseModel = new ResponseModel();
        responseModel.setMessage(users);
        return responseModel;
    }

    //get user
    @RequestMapping(method = RequestMethod.GET, path = "getuser/{id}")
    public ResponseModel findUserById(@PathVariable int id) {
        ResponseModel responseModel = new ResponseModel();
        User user = userDaoService.findUserById(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);
        else {

            responseModel.setMessage(user);
            return responseModel;
        }

    }

    //delete user
    @DeleteMapping("removeuser/{id}")
    public ResponseModel deleteUserById(@PathVariable int id) {
        ResponseModel responseModel = new ResponseModel();
        User user = userDaoService.deleteUserById(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);
        else {
            responseModel.setMessage(user);
            return responseModel;
        }

    }

    //saveuser
    @RequestMapping(method = RequestMethod.POST, path = "saveuser")
    public ResponseModel saveUser(@Valid @RequestBody User user) {
        int id = userDaoService.addUser(user);

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(200);
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("id", id);
        responseModel.setMessage(hashMap);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        return responseModel;
    }

    //saveuser with response entry
    @RequestMapping(method = RequestMethod.POST, path = "saveuserwithentry")
    public ResponseEntity<Object> saveUserWithEntry(@RequestBody User user) {
        int id = userDaoService.addUser(user);

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(200);
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("id", id);
        responseModel.setMessage(hashMap);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        return ResponseEntity.created(location).build();
    }
}
