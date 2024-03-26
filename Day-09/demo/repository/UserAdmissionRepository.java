package com.example.demo.repository;


   
    import java.util.List;
    
    import org.springframework.data.jpa.repository.JpaRepository;
    
    import com.example.demo.entity.UserAdmission;
    
    
    public interface UserAdmissionRepository extends JpaRepository<UserAdmission,Integer>{
        List<UserAdmission> findByUsername(String username);
    }
    
