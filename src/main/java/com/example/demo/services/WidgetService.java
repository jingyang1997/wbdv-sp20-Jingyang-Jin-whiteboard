package com.example.demo.services;

import com.example.demo.helpers.WidgetOrderSorter;
import com.example.demo.models.Topic;
import com.example.demo.models.Widget;
import com.example.demo.repositories.TopicRepository;
import com.example.demo.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {
    @Autowired
    WidgetRepository widgetRepository;
    @Autowired
    TopicRepository topicRepository;
    public Widget createWidget(Integer tid, Widget widget){
        Topic topic = topicRepository.findTopicById(tid);
        if(topic==null){return null;}
        widget.setTopic(topic);
        return widgetRepository.save(widget);
    }

    public List<Widget> findWidgetsForTopic(Integer tid){
        List<Widget> result = widgetRepository.findWidgetsForTopic(tid);
        result.sort(new WidgetOrderSorter());
        return result;
    }

    public int updateWidget(Integer wid, Widget widget){
        Widget w = widgetRepository.findWidgetById(wid);
        if(w==null){return 0;}
        Topic t = w.getTopic();
        widget.setTopic(t);
        widgetRepository.save(widget);
        return 1;
    }

    public int deleteWidget(Integer wid){
        if(!widgetRepository.findById(wid).isPresent()){
            return 0;
        }
        widgetRepository.deleteById(wid);
        return 1;
    }

    public Widget findWidgetById(Integer wid){
        return widgetRepository.findWidgetById(wid);
    }

    public List<Widget> findAllWidgets(){
        return (List<Widget>) widgetRepository.findAll();
    }

    public int updateAllWidgets(List<Widget> widgets) {
        int order = 0;
        for (Widget widget : widgets){
            Widget w = widgetRepository.findWidgetById(widget.getId());
            if(w==null){return 0;}
            Topic t = w.getTopic();
            widget.setTopic(t);
            order++;
            widget.setOrd(order);
            widgetRepository.save(widget);
        }
        return 1;
    }
}
