package edu.soft2.dao;

import edu.soft2.pojo.User;
import org.springframework.stereotype.Repository;

@Repository//向IOC容器中装配bean
public class UserDaoImpl implements UserDao {
    private User user;
    @Override
    //添加用户
    public int addUser(User user) {
        if (user != null) {
            //1.获取JDBC的链接对象Connection
            //2.sql语句拼接
            String sql = "insert user(name,pwd) values("+user.getName()+","+user.getPwd()+")";
            System.out.println("add的sql语句："+sql);
            //3.PreparedStatement执行sql语句，用executeUpdate
            //4.获取sql执行结果
            System.out.println("数据库add操作");
            return 1;
        }
        return 0;
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int deleteUser(User user){
        if (user != null) {
            String sql = "delete from user where name = "+user.getName();
            System.out.println("delete的sql语句"+sql);
            System.out.println("数据库delete操作");
            return 1;
        }
        return 0;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(User user){
        if (user != null) {
            String sql = "update user set name = " +user.getName()+"where name = "+user.getId();
            System.out.println("update的sql语句="+sql);
            System.out.println("数据库update操作");
            return 1;
        }
        return 0;
    }

    /**
     * 查找用户
     * @param
     * @return
     */
    public User findAllUser() {
        User user = new User();
            String sql = "select * from user";
            System.out.println("Query的sql语句="+sql);
            System.out.println("数据库的query操作");
            return user;
    }
}
