package com.example.demo.controller;


import com.example.demo.service.LoginService;
import com.example.demo.vo.LoginVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Data
@RestController
@Slf4j
@RequestMapping(value="/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	// @Autowired
	private LoginService loginservice;

	// @GetMapping(value = "/login")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginYn = (String) request.getSession().getAttribute("loginYn");
		if ("Y".equals(loginYn)) {
			response.sendRedirect("/");
			return null;
		}
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	// @PostMapping(value = "/login")
	public String login(@RequestBody LoginVo user, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		JsonModelAndView jmv = new JsonModelAndView();
//		String id = user.getUserId();
//		String pw = user.getUserPw();
//
//		String loginYn = (String) request.getSession().getAttribute("loginYn");
//		if("Y".equals(loginYn)){
////			jmv.put("resultCode", "400");
//			response.sendRedirect("/");
//			return "Y";
//		}

		//LoginVo loginUser = loginservice.selectUserFromId(id);

//
//		LoginVo loginUser = loginservice.selectUserFromIdPw(id, pw);
//		System.out.println(loginUser.getUserId() + loginUser.getUserPw());
//

//		if(loginUser == null){
//			//jmv.put("resultCode", "404");
//			return "N";
//		}
//
//
//		loginUser.setUserPw("");
//		request.getSession().setAttribute("loginYn", "Y");
//		request.getSession().setAttribute("loginUser", loginUser);
//
//		//jmv.put("resultCode", "000");
//		return "Y";
		return "hi";
	}


	@GetMapping(value="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("loginYn");
		request.getSession().removeAttribute("loginUser");
		request.getSession().invalidate();
		response.sendRedirect("/login");
	}




}
