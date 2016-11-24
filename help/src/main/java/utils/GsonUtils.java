package utils;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ISU on 2016/11/23.
 */
public class GsonUtils {
    private static Gson gson=new Gson();
    public static String getDataForList(List mList){
        return gson.toJson(mList);
    }
}
