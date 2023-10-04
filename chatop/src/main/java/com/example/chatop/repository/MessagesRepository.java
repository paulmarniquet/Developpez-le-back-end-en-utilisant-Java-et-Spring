package com.example.chatop.repository;

import com.example.chatop.entity.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends CrudRepository<Messages, Long> {}