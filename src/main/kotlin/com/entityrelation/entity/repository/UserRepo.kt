package com.entityrelation.entity.repository

import com.entityrelation.entity.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo :JpaRepository<User,Long>{


}