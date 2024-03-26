package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminCourseDto;
import com.example.demo.entity.AdminCourse;
import com.example.demo.repository.AdminCourseRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminCourseService {
    
        @Autowired
        private AdminCourseRepository adminCourseRepository;
    
        public AdminCourse addAdminCourse(AdminCourseDto adminCourseDto) {
            AdminCourse adminCourse = new AdminCourse();
            adminCourse.setCategory(adminCourseDto.getCategory());
            adminCourse.setCoursename(adminCourseDto.getCoursename());
            adminCourse.setFee(adminCourseDto.getFee());
            adminCourse.setNoofcourse(adminCourseDto.getNoofcourse());
        
            // int nextId = getNextCourseId(adminCourseDto.getCategory());
            // adminCourse.setId(nextId);
    
               // Get the next category-specific ID if it doesn't exist
               if (adminCourse.getCategorySpecificId() == null) {
                Long nextCategorySpecificId = getNextCategorySpecificId(adminCourseDto.getCategory());
                adminCourse.setCategorySpecificId(nextCategorySpecificId);
            }
        
            adminCourseRepository.save(adminCourse);
            return adminCourse;
        }
        
    
        private Long getNextCategorySpecificId(String category) {
            Long lastCategorySpecificId = adminCourseRepository.findLastCategorySpecificIdByCategory(category);
            return lastCategorySpecificId == null ? 1 : lastCategorySpecificId + 1;
        }
        // private int getNextCourseId(String category) {
        //     Integer lastCourseId = adminCourseRepository.findLastCourseIdByCategory(category);
        //     if (lastCourseId == null) {
        //         return 1;
        //     }
        //     return lastCourseId + 1;
        // }
        
    
        public List<AdminCourse> getCourses() {
            return adminCourseRepository.findAll();
        }
    
        public AdminCourse getAdminCourse(int id) {
            return adminCourseRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Course with ID: " + id + " not found"));
        }
    
        public AdminCourse putAdminCourse(int id, AdminCourseDto apd) {
            Optional<AdminCourse> checkCourse = adminCourseRepository.findById(id);
            if (checkCourse.isPresent()) {
                AdminCourse Course = checkCourse.get();
                Course.setCategory(apd.getCategory());
                Course.setCoursename(apd.getCoursename());
                Course.setFee(apd.getFee());
                Course.setNoofcourse(apd.getNoofcourse());
                return adminCourseRepository.save(Course);
            } else {
                return null;
            }
        }
    
        public String delAdminCourse(int id) {
            Optional<AdminCourse> optionalCourse = adminCourseRepository.findById(id);
            if (optionalCourse.isPresent()) {
                adminCourseRepository.deleteById(id);
                return "Admin deleted the Course with ID: " + id;
            } else {
                throw new NoSuchElementException("Course with ID: " + id + " not found");
            }
        }
        public List<AdminCourse> getCoursesByCategory(String category) {
            return adminCourseRepository.findByCategory(category);
        }
        }
    
    
