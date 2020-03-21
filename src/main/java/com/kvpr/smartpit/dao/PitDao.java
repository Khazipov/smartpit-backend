package com.kvpr.smartpit.dao;

import com.kvpr.smartpit.model.Pit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitDao extends JpaRepository<Pit, Long> {
}
