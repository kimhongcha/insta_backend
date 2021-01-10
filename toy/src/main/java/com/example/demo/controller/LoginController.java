package com.example.demo.controller;


import com.example.demo.common.spring.JsonModelAndView;
import com.example.demo.service.LoginService;
import com.example.demo.vo.LoginVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
@RestController
@Slf4j
@RequestMapping(value="/api/login")
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@GetMapping(value="/api/login")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginYn = (String) request.getSession().getAttribute("loginYn");
		if("Y".equals(loginYn) ){
			response.sendRedirect("/");
			return null;
		}
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@PostMapping(value="/api/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
							  @RequestBody LoginVo user) throws Exception{

		JsonModelAndView jmv = new JsonModelAndView();

		String id = user.getUserId();
		String pw = user.getUserPw();


		String loginYn = (String) request.getSession().getAttribute("loginYn");

		if("Y".equals(loginYn)){
//			jmv.put("resultCode", "400");
			response.sendRedirect("/");
			return null;
		}
		//아이디 검
		if(id == null || id.isEmpty()){
			jmv.put("resultCode", "401");
			return jmv;
		}
		// 패스워
		if(pw == null || pw.isEmpty()){
			jmv.put("resultCode", "402");
			return jmv;
		}

		LoginVo loginUser = loginservice.selectUserFromId(id);

		if(loginUser == null){
			jmv.put("resultCode", "403");
			return jmv;
		}

		loginUser = loginservice.selectUserFromIdPw(id, pw);
		if(loginUser == null){
			jmv.put("resultCode", "404");
			return jmv;
		}

		loginUser.setUserPw("");
		request.getSession().setAttribute("loginYn", "Y");
		request.getSession().setAttribute("loginUser", loginUser);

		jmv.put("resultCode", "000");
		return null;
	}

	@GetMapping(value="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("loginYn");
		request.getSession().removeAttribute("loginUser");
		request.getSession().invalidate();
		response.sendRedirect("/login");
	}




}
