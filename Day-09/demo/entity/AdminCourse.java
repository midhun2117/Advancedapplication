package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="_adminCourse")
    public class AdminCourse {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int id;
        private String category;
        private String Coursename;
        private float fee;
        private int noofcourse;
        private Long categorySpecificId;
    
    
    }
    