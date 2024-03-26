package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AdminCourseDto;
import com.example.demo.entity.AdminCourse;
import com.example.demo.service.AdminCourseService;

import java.util.List;
    import java.util.NoSuchElementException;
    
    @RestController
    @RequestMapping("/auth/admin")
    public class AdminCourseController {
    
        @Autowired
        private AdminCourseService adminCourseService;
    
        @PostMapping("/postadminCourse")
        @PreAuthorize("hasAuthority('ADMIN')")
        public ResponseEntity<AdminCourse> postAdminCourse(@RequestBody AdminCourseDto adminCourseDto) {
            AdminCourse Course = adminCourseService.addAdminCourse(adminCourseDto);
            return new ResponseEntity<>(Course, HttpStatus.CREATED);
        }
    
        @PreAuthorize("hasAuthority('ADMIN')")
        @GetMapping("/allCourse")
        public List<AdminCourse> getAllCourse() {
            return adminCourseService.getCourses();
        }
    
     
        @GetMapping("/getadminCourse/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        public ResponseEntity<AdminCourse> getAdminCourse(@PathVariable int id) {
            try {
                AdminCourse Course = adminCourseService.getAdminCourse(id);
                return new ResponseEntity<>(Course, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    
        @PutMapping("/putadminCourse/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
    
        public ResponseEntity<AdminCourse> updateAdminCourse(@PathVariable int id, @RequestBody AdminCourseDto adminCourseDto) {
            AdminCourse updatedCourse = adminCourseService.putAdminCourse(id, adminCourseDto);
            if (updatedCourse != null) {
                return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    
        @DeleteMapping("/deladminCourse/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
    
        public ResponseEntity<String> deleteAdminCourse(@PathVariable int id) {
            try {
                String message = adminCourseService.delAdminCourse(id);
                return new ResponseEntity<>(message, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
        @GetMapping("/getadmincategory/{category}")
        @PreAuthorize("hasAuthority('ADMIN')")
        public ResponseEntity<List<AdminCourse>> getCoursesByCategory(@PathVariable String category) {
            List<AdminCourse> Courses = adminCourseService.getCoursesByCategory(category);
            return new ResponseEntity<>(Courses, HttpStatus.OK);
        }
    }
    
