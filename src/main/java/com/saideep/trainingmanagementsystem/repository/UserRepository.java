package com.saideep.trainingmanagementsystem.repository;

import com.saideep.trainingmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
