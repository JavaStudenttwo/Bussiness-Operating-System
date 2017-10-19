package cn.itcast.bos.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonTransform<T>{

    public List<T> transformForList(String json){

        Gson gson = new Gson();
        List<T> list = gson.fromJson(json,new TypeToken<List<T>>(){}.getType());

        return list;
    }



}
