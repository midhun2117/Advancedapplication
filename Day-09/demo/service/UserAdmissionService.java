package com.example.demo.service;



import java.util.List;
    import java.util.NoSuchElementException;
    import java.util.Optional;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.example.demo.dto.UserAdmissionDto;
import com.example.demo.entity.UserAdmission;
import com.example.demo.repository.UserAdmissionRepository;
    
    
    
    @Service
        public class UserAdmissionService {
        @Autowired
        private UserAdmissionRepository userAdmissionRepository;
    
        public UserAdmission addUserAdmission(UserAdmissionDto userAdmissionDto){
            UserAdmission userAdmission=new UserAdmission();
            userAdmission.setCoursename(userAdmissionDto.getCoursename());
            userAdmission.setUsername(userAdmissionDto.getUsername());
            userAdmission.setNoofcourse(userAdmissionDto.getNoofcourse());
            userAdmission.setTiming(userAdmissionDto.getTiming());
            userAdmissionRepository.save(userAdmission);
            return userAdmission;
        }
        public List<UserAdmission> getAdmissionByUsername(String username) {
            return userAdmissionRepository.findByUsername(username);
        }
            public List<UserAdmission> getUserAdmission() {
            return userAdmissionRepository.findAll();
        }
    
        public UserAdmission getUserAdmission(int id) {
            return userAdmissionRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Course with ID: " + id + " not found"));
        }
            public String delUserAdmission(int id) {
            Optional<UserAdmission> optionalAdmission = userAdmissionRepository.findById(id);
            if (optionalAdmission.isPresent()) {
                userAdmissionRepository.deleteById(id);
                return "Admin deleted the Course with ID: " + id;
            } else {
                throw new NoSuchElementException("Course with ID: " + id + " not found");
            }
        }
    
        
    }
    
