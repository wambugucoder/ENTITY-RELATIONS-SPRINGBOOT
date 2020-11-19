package com.entityrelation.entity.repository

import com.entityrelation.entity.models.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepo :JpaRepository<Address,Long>{

}