package com.example.demo.controller;


import com.example.demo.Dto.MemberDto;
import com.example.demo.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor

@RequestMapping(value = "/api")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/login")
	public String login(@RequestBody MemberDto memberDto, HttpServletRequest request, HttpServletResponse response){

		String id = memberDto.getUsername();
		String password = memberDto.getPassword();
		System.out.println(id + password);


		return "Y";

	}



}
