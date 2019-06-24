package com.sxd.server.mytime.service.userservice;

import com.sxd.server.mytime.entity.Follow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FollowServiceTest {
    @Autowired
    private FollowService followService;

    @Test
    public void getFollowTest0() {
        assertThat(followService.getFollow(-1), is(empty()));
    }

    @Test
    public void getFollowTest1() {
        assertThat(followService.getFollow(10).size(),greaterThan(0));
    }

    @Test
    public void getFollowTest2() {
        assertThat(followService.getFollow(100), is(empty()));
    }


    @Test
    public void followUserTest0() {
        Follow follow = new Follow();
        follow.setFollowingId(11);
        follow.setFollowedId(10);
        assertThat(followService.followUser(follow),is(1));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void followUserTest1() {
        Follow follow = new Follow();
        follow.setFollowingId(11);
        follow.setFollowedId(null);
        followService.followUser(follow);
    }

    @Test
    public void deleteFollowTest0() {
        assertThat(followService.deleteFollow(10,11),is(1));
    }

    @Test
    public void deleteFollowTest1() {
        assertThat(followService.deleteFollow(10,100),is(0));
    }

    @Test
    public void deleteFollowTest2() {
        assertThat(followService.deleteFollow(10,null),is(0));
    }

    @Test
    public void deleteFollowTest3() {
        assertThat(followService.deleteFollow(null,11),is(0));
    }
}