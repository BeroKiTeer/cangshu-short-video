package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.mapper.FollowsMapper;
import cn.edu.ujn.shortvideo.service.FollowsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class FollowsServiceImpl implements FollowsService {

    @Resource
    private FollowsMapper followsMapper;

    /**
     *
     * @param followerId
     * @param followedId
     */
    @Override
    public void follow(int followerId, int followedId) {
        followsMapper.insertFollow(followerId, followedId);
    }

    /**
     *
     * @param followId
     */
    @Override
    public void unfollow(int followId) {
        followsMapper.deleteFollow(followId);
    }
}
