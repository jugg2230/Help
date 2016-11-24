package dao;

import bean.HelpInfo;
import db.DBAcess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ISU on 2016/11/23.
 */
public class HelpInfoDao {
    public List<HelpInfo> queryHelpInfoList(String classification, String title) {
        DBAcess dbAcess = new DBAcess();
        List<HelpInfo> helpInfoList = new ArrayList<HelpInfo>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAcess.getSqlSession();
            HelpInfo helpInfo = new HelpInfo();
            helpInfo.setClassification(classification);
            helpInfo.setTitle(title);
            //通过sqlSession执行SQL语句
            helpInfoList = sqlSession.selectList("HelpInfo.queryHelpInfoList",helpInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return helpInfoList;
    }

    public static void main(String[] args) {
        HelpInfoDao helpInfoDao = new HelpInfoDao();
        System.out.println(helpInfoDao.queryHelpInfoList("Java",""));

    }
}
