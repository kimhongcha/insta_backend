package com.example.demo.service;


import com.example.demo.dao.LoginDao;
import com.example.demo.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class LoginService {

	@Autowired
	private LoginDao loginDao;

	public LoginVo selectUserFromId(String id){
		return loginDao.selectUserFromId(id);

	}
	public LoginVo selectUserFromIdPw(String id, String pw){
		LoginVo param = new LoginVo();
		param.setUserId(id);
		param.setUserPw(pw);
		return loginDao.selectUserFromIdPw(param);

	}



}
