package com.rohan.dynamic_spring_sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rohan.dynamic_spring_sec.entity.Matcher;
import com.rohan.dynamic_spring_sec.repository.MatcherRepository;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private MatcherRepository matcherRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		assignDefaultSecurityConfiguration();
	}

	void assignDefaultSecurityConfiguration() {
		long count = matcherRepository.count();
		if (count < 1) {
			Matcher loginUrl = new Matcher();
			loginUrl.setUrl("/token/*");
			matcherRepository.save(loginUrl);
		}
	}
}
