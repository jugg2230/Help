package controller;

import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.util.SystemUtils;
import dao.HelpInfoDao;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.GsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ISU on 2016/11/23.
 */
@Controller
public class MyController {
    @ResponseBody
    @RequestMapping(value = "/getHelpInfo", method = RequestMethod.GET)
    public void getHelpInfo(HttpServletRequest request,HttpServletResponse response){
        String classification=request.getParameter("name");
        String title = null;
        try {
            title = new String(request.getParameter("title").getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HelpInfoDao helpInfoDao=new HelpInfoDao();
        List mList=helpInfoDao.queryHelpInfoList(classification,title);
        String json=GsonUtils.getDataForList(mList);
        System.out.println(classification+title);
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
