package com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.entity.LoginLog;
import com.spring.entity.User;
import com.spring.mapper.ILoginLogDao;
import com.spring.mapper.IUserDao;
import com.spring.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao userdao;
	@Autowired
	private ILoginLogDao loginlogdao;

	public boolean getMatchCount(String uname, String password) {
		return userdao.getMatchCount(uname, password);
	}

	public User findUserByUserName(String name) {
		return userdao.findUserByUserName(name);
	}

	public void loginSuccess(User user) {
		LoginLog loginlog = new LoginLog();
		loginlog.setUser_id(user.getUser_id());
		loginlog.setLogin_datetime(user.getLast_visit());
		loginlog.setIp(user.getLast_Ip());
		loginlogdao.insertLoginLog(loginlog);

	}

}
