package com.example.demo.services;

import com.example.demo.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
    List<Widget> WidgetList = new ArrayList<Widget>();
    

    public Widget createWidget(String tid, Widget widget){
        widget.setTopicid(tid);
        WidgetList.add(widget);
        return widget;
    }
    public List<Widget> findWidgetsForTopic(String tid){
        List<Widget> WidgetListfortopic = new ArrayList<Widget>();
        for(Widget widget : WidgetList){
            if(widget.getTopicid().equals(tid)){
                WidgetListfortopic.add(widget);
            }
        }
        return WidgetListfortopic;
    }
    public int updateWidget(String wid, Widget widget){
        int Flag = 0;
        for(int i = 0; i < WidgetList.size(); i++){
            if(WidgetList.get(i).getId().equals(wid)){
                WidgetList.set(i, widget);
                Flag = 1;
                break;
            }
        }
        return Flag;
    }
    public int deleteWidget(String wid){
        int FLAG = 0;
        for(Widget widget : WidgetList){
            if(widget.getId().equals(wid)){
                FLAG = 1;
                break;
            }
        }
        if (FLAG == 0) {
            return FLAG;
        }
        WidgetList = WidgetList.stream().filter(w -> !w.getId().equals(wid)).collect(Collectors.toList());
        return FLAG;
    }
    public Widget findWidgetById(String wid){
        for(Widget widget : WidgetList){
            if(widget.getId().equals(wid)){
                return widget;
            }
        }
        return null;
    }
    public List<Widget> findAllWidgets(){
        return WidgetList;
    }
}
