package cn.edu.ujn.shortvideo.service;

public interface FollowsService {
    /**
     *
     * @param followerId
     * @param followedId
     */
    void follow(int followerId, int followedId);

    /**
     *
     * @param followId
     */
    void unfollow(int followId);
}
