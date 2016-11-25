package dao;

import bean.LoginInfo;
import db.DBAcess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ISU on 2016/11/25.
 */
public class LoginInfoDao {
    public List<LoginInfo> queryLoginInfoList(String uaccount) {
        DBAcess dbAcess = new DBAcess();
        List<LoginInfo> loginInfoList = new ArrayList<LoginInfo>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAcess.getSqlSession();
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setUaccount(uaccount);
            //通过sqlSession执行SQL语句
            loginInfoList = sqlSession.selectList("LoginInfo.queryLoginInfoList",loginInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return loginInfoList;
    }

        public static void main(String[] args) {
        LoginInfoDao loginInfoDao = new LoginInfoDao();
        System.out.println(loginInfoDao.queryLoginInfoList("lisi").get(0).getUname());
    }
}
