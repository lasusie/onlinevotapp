/*******************************************************************************
 * Copyright 2015 Brient Oh @ Pristine Core
 * boh@pristinecore.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.mysample.springbootsample.security;

import com.mysample.springbootsample.entity.UserEntity;
import com.mysample.springbootsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		UserEntity user = userRepository.findByUsername(username);
		System.out.println(user);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return buildUserForAuthentication(user, buildUserAuthority());
	}
	
	private User buildUserForAuthentication(com.mysample.springbootsample.entity.UserEntity user,
			List<GrantedAuthority> authorities) {
		
		return new User(user.getUsername(), user.getPassword(),
				true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(0);
		authorities.add(new SimpleGrantedAuthority("ROLE_USR"));

		
		return authorities;
	}

}
