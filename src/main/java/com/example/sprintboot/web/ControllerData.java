package com.example.sprintboot.web;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class ControllerData {

    public List<DataDao> querydata(){
        List<DataDao> dataList = new ArrayList<>();
        dataList.add(new DataDao("monai123","123465798"));
        return dataList;
    }
    private static ControllerData instance = null;
    public static ControllerData getInstance(){
        if(instance == null){
            instance = new ControllerData();
        }
        return instance;
    }
}
