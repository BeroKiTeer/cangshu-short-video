package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.mapper.FollowsMapper;
import cn.edu.ujn.shortvideo.service.FollowsService;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

public class FollowsServiceImpl implements FollowsService {

    @Resource
    private FollowsMapper followsMapper;

    @Override
    @Transactional
    public void follow(int followerId, int followedId) {
        followsMapper.insertFollow(followerId, followedId);
    }

    @Override
    @Transactional
    public void unfollow(int followId) {
        followsMapper.deleteFollow(followId);
    }
}
