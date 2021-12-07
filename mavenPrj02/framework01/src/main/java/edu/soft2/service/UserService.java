package edu.soft2.service;

import edu.soft2.pojo.User;

public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int deleteUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 查找用户
     * @param
     * @return
     */
    public User findAllUser();
}
