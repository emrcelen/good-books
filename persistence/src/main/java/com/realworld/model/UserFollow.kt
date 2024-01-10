package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "UserFollow")
@Table(name = "userfollow")
data class UserFollow(
    var followingID: Account?,
    var followersID: Account?
)
