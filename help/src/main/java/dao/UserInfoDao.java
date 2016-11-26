package dao;

import bean.UserInfo;
import db.DBAcess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * Created by ISU on 2016/11/25.
 */
public class UserInfoDao {
    public void insertUserInfo() {
        DBAcess dbAcess = new DBAcess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAcess.getSqlSession();
            UserInfo user = new UserInfo();
            user.setUid(6);
            user.setUname("沈八");
//            user.setMobile("");
//            user.setUintro("");
//            user.setUavatarurl("");
//            user.setUavatarbase64("");
            user.setSchool("清华大学");
            user.setSid(6);
            user.setGender("男");
            user.setMajor("Linux");
//            user.setToken("");
            //通过sqlSession执行SQL语句
            sqlSession.insert("UserInfo.insertUserInfo", user);
            sqlSession.commit();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args) {
        UserInfoDao userInfoDao = new UserInfoDao();
        userInfoDao.insertUserInfo();
    }
}
