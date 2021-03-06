package com.lc.clz.controller;

import com.lc.clz.entities.User;
import com.lc.clz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public User addUser(User user){
        user=new User();
        return userServiceImpl.addUser(user);
    }

    /**
     * 修改用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/update/{userId}", produces = {"application/json;charset=UTF-8"})
    public User updateUser(@PathVariable("userId") Long userId){
        return userServiceImpl.updateUser(userId);
    }

    /**
     * 查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/select/{userId}", produces = {"application/json;charset=UTF-8"})
    public User selectUser(@PathVariable("userId") Long userId){
        return userServiceImpl.selectUser(userId);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete/{userId}", produces = {"application/json;charset=UTF-8"})
    public String  deleteUser(@PathVariable("userId") Long userId){
        try{
            userServiceImpl.deleteUser(userId);
        }catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }

    /**
     * 分页查询用户
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/selectUserWithPage", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> selectUserWithPage(@PathVariable("page") Integer page,@PathVariable("limit") Integer limit){
        return userServiceImpl.selectUserWithPage(page,limit);
    }

}

