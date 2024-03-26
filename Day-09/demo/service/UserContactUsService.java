package com.example.demo.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserContactUsDto;
import com.example.demo.entity.UserContactUs;
import com.example.demo.repository.UserContactUsRepository;


@Service
public class UserContactUsService {
    @Autowired
    private UserContactUsRepository userContactUsRepository;

    public UserContactUs addContactUs(UserContactUsDto userContactUsDto){
        UserContactUs userContactUs=new UserContactUs();
        userContactUs.setFirstname(userContactUsDto.getFirstname());
        userContactUs.setEmailid(userContactUsDto.getEmailid());
        userContactUs.setMobile(userContactUsDto.getMobile());
        userContactUs.setQuery(userContactUsDto.getQuery());
        userContactUs.setSubject(userContactUsDto.getSubject());
        userContactUsRepository.save(userContactUs);
        return userContactUs;
    }
      public List<UserContactUs> getUserContactUs() {
        return userContactUsRepository.findAll();
    }

    
}

