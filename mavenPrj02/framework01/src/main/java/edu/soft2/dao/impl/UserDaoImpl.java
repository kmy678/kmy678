package edu.soft2.dao.impl;

import edu.soft2.dao.UserDao;
import edu.soft2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private User user;

    @Override
    public int addUser(User user) {
        if (user != null){
            String sql = "insert user(name,pwd) valuses("+user.getName()+","+user.getPwd()+")";
            System.out.println("add的sql语句："+sql);
            System.out.println("数据库add操作");
            return 1;
        }
        return 0;
    }

    public int deleteUesr(User user) {
        if (user != null){
            System.out.println("数据库detele操作");
            return 1;
        }
        return 0;
    }

    public int updateUser(User user) {
        if (user != null){
            System.out.println("数据库update操作");
            return 1;
        }
        return 0;
    }

    @Override
    public int queryUser(User user) {
        if (user != null){
            System.out.println("数据库update操作");
            return 1;
        }
        return 0;
    }
}
