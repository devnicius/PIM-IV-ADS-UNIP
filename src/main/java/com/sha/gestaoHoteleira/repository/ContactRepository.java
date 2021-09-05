package com.sha.gestaoHoteleira.repository;

import com.sha.gestaoHoteleira.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {} 

