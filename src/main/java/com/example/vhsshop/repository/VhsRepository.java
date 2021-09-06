package com.example.vhsshop.repository;

import com.example.vhsshop.model.Vhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VhsRepository extends JpaRepository<Vhs, Long> {
}
