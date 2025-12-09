package com.tms.tms_backend.repository;


import com.tms.tms_backend.entity.Load;
import com.tms.tms_backend.enums.LoadStatusType;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Load, UUID> {

    List<Load> findByShipperIdAndStatus(String shipperId, LoadStatusType status);
    List<Load> findByStatus(LoadStatusType statusType);
    List<Load> findByShipperId(String shipperId);



}
