package com.entityrelation.entity.controller

import com.entityrelation.entity.models.Tweets
import com.entityrelation.entity.models.User
import com.entityrelation.entity.repository.TweetRepo
import com.entityrelation.entity.repository.UserRepo
import com.entityrelation.entity.response.TweetResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
class TweetController {
    @Autowired
    lateinit var tweetRepo: TweetRepo
    @Autowired
    lateinit var  userRepo: UserRepo

    @PostMapping("/new/{userId}/Tweet",consumes = [MediaType.ALL_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createTweet(@PathVariable userId:Long,@RequestBody tweet:Tweets): ResponseEntity<TweetResponse> {

        if(userRepo.existsById(userId)){
        userRepo.findById(userId).map {user->
            val newTweet=Tweets(tweet.tweet, user)
            tweetRepo.save(newTweet)
        }
            return ResponseEntity.ok(TweetResponse("Tweet Saved Succesfully"))
        }
        return ResponseEntity.badRequest().body(TweetResponse("User Does Not Exist"))
    }
    @GetMapping("/tweets",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTweets(): MutableList<Tweets> {
        return tweetRepo.findAll()
    }
    @PutMapping("/tweet/{id}",consumes=[MediaType.ALL_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateTweet(@PathVariable id:Long,@RequestBody request:Tweets): ResponseEntity<TweetResponse> {
      tweetRepo.findById(id).map { Tweets->
          Tweets.tweet=request.tweet
         // val newT=Tweets(Tweets.tweet)
          tweetRepo.save(Tweets)

      }
        return ResponseEntity.ok(TweetResponse("Tweet has been Updated"))


    }
    @DeleteMapping("/remove/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteTweet(@PathVariable id: Long):ResponseEntity<TweetResponse>{
        tweetRepo.deleteById(id)
        return ResponseEntity.ok(TweetResponse("Tweet Deleted Succesfully"))
    }
}


