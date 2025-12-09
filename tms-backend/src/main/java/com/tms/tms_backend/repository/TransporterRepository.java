package com.tms.tms_backend.repository;

import com.tms.tms_backend.entity.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TransporterRepository extends JpaRepository<Transporter, UUID> {
}
