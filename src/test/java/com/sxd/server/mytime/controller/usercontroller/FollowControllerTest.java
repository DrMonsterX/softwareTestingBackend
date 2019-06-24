package com.sxd.server.mytime.controller.usercontroller;

import com.sxd.server.mytime.entity.Follow;
import com.sxd.server.mytime.entity.User;
import com.sxd.server.mytime.service.userservice.FollowService;
import com.sxd.server.mytime.service.userservice.GetUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FollowControllerTest {

    @Test
    public void getFollowTest0() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(followService.getFollow(-1)).thenReturn(new ArrayList<>());
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.getFollow(-1),is(empty()));
    }

    @Test
    public void getFollowTest1() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        List<Follow> list = new ArrayList<>();
        Follow follow = new Follow();
        list.add(follow);
        when(followService.getFollow(10)).thenReturn(list);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.getFollow(10).size(),greaterThan(0));
    }

    @Test
    public void followUserTest0() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.followUser(any(Follow.class))).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.followUser(100,10),is(-3));
    }

    @Test
    public void followUserTest1() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.followUser(any(Follow.class))).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.followUser(10,100),is(-4));
    }

    @Test
    public void followUserTest2() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.followUser(any(Follow.class))).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.followUser(10,12),is(1));
    }

    @Test
    public void followUserTest3() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.followUser(any(Follow.class))).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.followUser(10,10),is(-2));
    }

    @Test
    public void deleteFollowTest0() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.deleteFollow(anyInt(),anyInt())).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.deleteFollow(100,10),is(-3));
    }

    @Test
    public void deleteFollowTest1() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.deleteFollow(anyInt(),anyInt())).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.deleteFollow(10,100),is(-4));
    }

    @Test
    public void deleteFollowTest2() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.deleteFollow(anyInt(),anyInt())).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.deleteFollow(10,12),is(1));
    }

    @Test
    public void deleteFollowTest3() {
        FollowService followService = mock(FollowService.class);
        GetUserService getUserService = mock(GetUserService.class);
        when(getUserService.getUser(anyInt())).thenReturn(new User());
        when(getUserService.getUser(100)).thenReturn(null);
        when(followService.deleteFollow(anyInt(),anyInt())).thenReturn(1);
        FollowController followController = new FollowController(followService,getUserService);
        assertThat(followController.deleteFollow(10,10),is(-2));
    }
}