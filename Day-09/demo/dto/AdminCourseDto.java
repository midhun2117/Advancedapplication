package com.example.demo.dto;



    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class AdminCourseDto {
        private int id;
        private String category;
        private String Coursename;
        private float fee;
        private int noofcourse;
        private Long categorySpecificId;
    
    }
    
