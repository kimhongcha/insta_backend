package com.example.demo.Domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="member")

public class Member {

	@Id
	private Long id;

	@NotNull
	private String username;
	@NotNull
	private String password;

	@Builder
	public Member(Long id, String username, String password){
		this.id = id;
		this.username = username;
		this.password = "{noop}" + password;
	}
}

