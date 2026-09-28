package com.example.stockalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stockalert.model.Reorderalerts;

public interface ReorderAlertsRepository extends JpaRepository<Reorderalerts, Long> {

}