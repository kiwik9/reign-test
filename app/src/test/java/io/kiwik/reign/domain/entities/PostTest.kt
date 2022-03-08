package io.kiwik.reign.domain.entities

import org.joda.time.DateTime
import org.junit.Before
import org.junit.Test

class PostTest {

    private lateinit var post: Post

    @Before
    fun setUp() {
        post = Post(0, "test", "test", "test", "test", DateTime.now())
        post.createdAt = DateTime.now().minusMinutes(30)
    }

    @Test
    fun getDifDate() {
        assert("30 m." == post.getDifDate())
    }
}