package com.example.demo.service;

import com.example.demo.Domain.Member;
import com.example.demo.Dto.MemberDto;
import com.example.demo.Repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class MemberService implements UserDetailsService {

	private MemberRepository memberRepository;

	@Transactional
	public Long signUp(MemberDto memberDto){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));


		return memberRepository.save(memberDto.toEntity()).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Member> memberWrapper = memberRepository.findByusername(username);
		Member member = memberWrapper.get();
		List<GrantedAuthority> authorities = new ArrayList<>();

		if ("admin".equals(username)){
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));

		}else{
			authorities.add(new SimpleGrantedAuthority((Role.MEMBER.getValue())));

		}

		return new User(member.getUsername(), member.getPassword(),authorities);
	}



}
