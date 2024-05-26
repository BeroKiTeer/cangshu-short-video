package cn.edu.ujn.shortvideo.service;

public interface FollowsService {
    void follow(int followerId, int followedId);
    void unfollow(int followId);
}
