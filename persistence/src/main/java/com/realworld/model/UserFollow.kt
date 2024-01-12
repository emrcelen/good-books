package com.realworld.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "UserFollow")
@Table(name = "userfollow", schema = "good_books")
data class UserFollow(
    var followingID: Account?,
    var followersID: Account?
) {
    protected constructor() : this(Builder())

    private constructor(builder: Builder) : this(
        builder.followingID,
        builder.followersID
    )

    class Builder {
        var followingID: Account? = null
            private set
        var followersID: Account? = null
            private set

        fun followingID(followingID: Account) = apply { this.followingID = followingID }
        fun followersID(followersID: Account) = apply { this.followersID = followersID }
    }


}
