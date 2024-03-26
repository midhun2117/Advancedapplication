package com.example.demo.controller;



import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserAdmissionDto;
import com.example.demo.entity.UserAdmission;
import com.example.demo.service.UserAdmissionService;
    
    
    
    
    @RestController
    @RequestMapping("/auth")
        public class UserAdmissionController {
        @Autowired
        private UserAdmissionService userAdmissionService;
         @PostMapping("/user/postuserAdmission")
             @PreAuthorize("hasAuthority('USER')")
    
        public ResponseEntity<UserAdmission> addUserAdmission(@RequestBody UserAdmissionDto userAdmissionDto) {
            UserAdmission userAdmission = userAdmissionService.addUserAdmission(userAdmissionDto);
            return new ResponseEntity<>(userAdmission, HttpStatus.CREATED);
        }
    
        @PreAuthorize("hasAuthority('ADMIN')")
        @GetMapping("/admin/alluserAdmission")
        public ResponseEntity<List<UserAdmission>> getAllUserAdmission() {
            List<UserAdmission> userAdmissionList = userAdmissionService.getUserAdmission();
            return new ResponseEntity<>(userAdmissionList, HttpStatus.OK);
        }
    
        @PreAuthorize("hasAuthority('ADMIN')")
        @GetMapping("/admin/getuserAdmission/{id}")
        public ResponseEntity<UserAdmission> getUserAdmissionById(@PathVariable int id) {
            UserAdmission userAdmission = userAdmissionService.getUserAdmission(id);
            return new ResponseEntity<>(userAdmission, HttpStatus.OK);
        }
    
        @GetMapping("/user/getuserAdmission/{username}")
        @PreAuthorize("hasAuthority('USER')")
        public ResponseEntity<List<UserAdmission>> getAdmissionByUsername(@PathVariable String username) {
            List<UserAdmission> userAdmissionList = userAdmissionService.getAdmissionByUsername(username);
            return new ResponseEntity<>(userAdmissionList, HttpStatus.OK);
        }
    
        @PreAuthorize("hasAuthority('ADMIN')")
        @DeleteMapping("/admin/deluserAdmission/{id}")
        public ResponseEntity<String> deleteUserAdmission(@PathVariable int id) {
            String message = userAdmissionService.delUserAdmission(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        
    }
    
