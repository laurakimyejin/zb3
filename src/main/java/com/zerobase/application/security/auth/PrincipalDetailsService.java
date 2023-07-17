package com.zerobase.application.security.auth;

import com.zerobase.domain.User;
import com.zerobase.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private final UserRepository userRepository;
	
	//login 동작을 할 때 실행됨.
	//view에서 파라미터로 넘어온 username을 토대로 User 찾아서 객체를 PrincipalDetails 객체에 저장하는 메소드
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		
		User userEntity = userRepository.findByUserid(userid);
		
		if(userEntity != null) {
			return new PrincipalDetails(userEntity);
		}
		return null;
		//return new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
		//-> PrincipalDetails 객체가 DB에서 User정보를 가져와 필드로 저장한다.
		//-> PrincipalDetails가 리턴되면 Authentication 내부에 저장된다.
		// 그런 후 Authentication이 스프링 시큐리티의 session 내부에 들어가게 된다.
	
	}
}
