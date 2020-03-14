package com.example.demo.controllers;
import com.example.demo.models.Widget;
import com.example.demo.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService service;
    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets(){
        return service.findAllWidgets();
    }
    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Integer wid){
        return service.findWidgetById(wid);
    }
    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid){
        int ttid;
        try{
            ttid = Integer.parseInt(tid);
            return service.findWidgetsForTopic(ttid);
        } catch (NumberFormatException e){
            List<Widget> result = new ArrayList<Widget>();
            return result;
        }
    }
    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") Integer wid){
        return service.deleteWidget(wid);
    }
    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable("tid") Integer tid, @RequestBody Widget widget){
        return service.createWidget(tid,widget);
    }
    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") Integer wid, @RequestBody Widget widget){
        return service.updateWidget(wid, widget);
    }
    @PutMapping("/api/widgets")
    public int updateAllWidgets(@RequestBody List<Widget> widgets){
        return service.updateAllWidgets(widgets);
    }
}
