package com.situ.myshop.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.myshop.user.domain.User;
@Repository
public interface UserDao {
	Long save(User user);

	User get(Long rowId);

	List<User> find();//查询所有信息
	
	void update(User user);
	
	void delete(Long rowId);
	
	User getByName(String userName);
	
	List<User> findByPage(@Param("searchUser")User searchUser,@Param("firstResult") Integer firstResult, @Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchUser")User searchUser);

	User getByCode(String userCode);

	User userLogin(@Param("userCode")String userCode, @Param("userPass")String userPass);//用户登录

	User adminLogin(@Param("adminCode")String adminCode, @Param("adminPass")String adminPass);//管理员登录


}
