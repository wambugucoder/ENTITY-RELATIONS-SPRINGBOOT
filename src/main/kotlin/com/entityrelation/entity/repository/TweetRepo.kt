package com.entityrelation.entity.repository

import com.entityrelation.entity.models.Tweets
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TweetRepo: JpaRepository<Tweets,Long>{

}