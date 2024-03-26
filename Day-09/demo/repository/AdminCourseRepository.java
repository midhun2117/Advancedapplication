package com.example.demo.repository;

  
    import java.util.List;
    
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.AdminCourse;
    
    
    
    public interface AdminCourseRepository extends JpaRepository<AdminCourse,Integer>{
        @Query("SELECT MAX(p.id) FROM AdminCourse p WHERE p.category = :category")
        Integer findLastCourseIdByCategory(String category);
    
        List<AdminCourse> findByCategory(String category);
        @Query("SELECT MAX(p.categorySpecificId) FROM AdminCourse p WHERE p.category = :category")
        Long findLastCategorySpecificIdByCategory(String category);
    }
    
