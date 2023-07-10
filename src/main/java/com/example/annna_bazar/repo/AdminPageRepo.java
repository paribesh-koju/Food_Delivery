package com.example.annna_bazar.repo;

import com.example.annna_bazar.entity.AdminPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminPageRepo extends JpaRepository<AdminPage,Integer> {
}
