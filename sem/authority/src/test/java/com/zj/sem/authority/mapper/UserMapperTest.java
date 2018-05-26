package com.zj.sem.authority.mapper;

import static org.junit.Assert.*;

import com.zj.sem.authority.model.User;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * com.zj.sem.authority.mapper.UserMapperTest
 * <p>
 * 类的简述.
 * </p>
 *
 * @author zhangjian  2018/5/26  7:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
  
  @Autowired
  private UserMapper userMapper;

  @Test
  public void testGetUser() {
    User result = userMapper.getUser(1L);
    Assert.notNull(result,"resulet is null,error");
    System.out.println(result.toString());
  }

  @Test
  public void testFindAll() {
    List<User> users = userMapper.listAllUser();
    System.out.println(users.size());
    
  }
  
  @Test
  public void testSaveUser(){
    User user = new User();
//    user.setId(3L);
    user.setName("test11");
    user.setPassword("123456");
    user.setEmail("2@2");
    user.setValid(0);
//    user.setCreatedBy(1L);
//    user.setCreatedTime(LocalDateTime.now());
//    user.setUpdatedBy(2L);
//    user.setUpdatedTime(LocalDateTime.now().plusDays(2));
    
    userMapper.saveUser(user);
  }
}
