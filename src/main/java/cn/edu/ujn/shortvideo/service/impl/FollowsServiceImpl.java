package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.mapper.FollowsMapper;
import cn.edu.ujn.shortvideo.service.FollowsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class FollowsServiceImpl implements FollowsService {

    @Resource
    private FollowsMapper followsMapper;

    /**
     * 用户关注操作。
     * 该方法实现了用户关注另一个用户的功能。通过调用followsMapper的insertFollow方法，
     * 在数据库中插入一条关注记录，从而建立关注关系。
     *
     * @param followerId 关注者的用户ID。表示哪个用户进行了关注操作。
     * @param followedId 被关注者的用户ID。表示哪个用户被关注。
     */
    @Override
    @Transactional
    public void follow(int followerId, int followedId) {
        followsMapper.insertFollow(followerId, followedId);
    }


    /**
     * 取消关注操作。
     *
     * @param followId 被关注者的ID，通过该ID在数据库中查找并删除关注关系。
     */
    @Override
    @Transactional
    public void unfollow(int followId) {
        followsMapper.deleteFollow(followId);
    }

}
