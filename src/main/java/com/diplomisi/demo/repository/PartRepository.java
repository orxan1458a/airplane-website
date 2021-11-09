package com.diplomisi.demo.repository;

import com.diplomisi.demo.model.PartOfAirplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<PartOfAirplane,Long> {
}
