package com.example.demo.dao;

import com.example.demo.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;


@Repository
@Slf4j
public class LoginDao {

	@Autowired
	private SqlSession sqlSession;

	public LoginVo selectUserFromId(String id){
		return sqlSession.selectOne("selectUserFromId",id);

	}
	public LoginVo selectUserFromIdPw(LoginVo param){
		return sqlSession.selectOne("selectUserFromId",param);
	}


}
