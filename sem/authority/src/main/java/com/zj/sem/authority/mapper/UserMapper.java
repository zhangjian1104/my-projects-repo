package com.zj.sem.authority.mapper;

import com.zj.sem.authority.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * com.zj.sem.authority.mapper.UserMapper
 * <p>
 * 类的简述.
 * </p>
 *
 * @author zhangjian  2018/5/25  20:18
 */
@Repository
public interface UserMapper {

  User getUser(Long id);

  List<User> listAllUser();

  void saveUser(User user);

  void updateUser(User user);
}
