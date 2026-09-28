package com.example.stockalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stockalert.model.Stocksmovement;

public interface StockmovementsRepository extends JpaRepository<Stocksmovement, Long> {

}