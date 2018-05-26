package com.zj.sem.authority.controller;

import com.zj.sem.authority.mapper.UserMapper;
import com.zj.sem.authority.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.zj.sem.authority.controller.UserController
 * <p>
 * 类的简述.
 * </p>
 *
 * @author zhangjian  2018/5/26  12:06
 */
@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private UserMapper userMapper;
  
  @GetMapping("/{id}")
  public User getUser(@PathVariable("id") Long id){
    return userMapper.getUser(id);
  }
}
