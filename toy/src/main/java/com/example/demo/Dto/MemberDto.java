package com.example.demo.Dto;

import com.example.demo.Domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class MemberDto {

	private Long id;
	private String username;
	private String password;

	public Member toEntity(){
		return Member.builder()
				.id(id)
				.username(username)
				.password(password)
				.build();
	}
	@Builder
	public MemberDto(Long id, String username, String password){
		this.id = id;
		this.username = username;
		this.password = "{noop}" + password;


	}
}
