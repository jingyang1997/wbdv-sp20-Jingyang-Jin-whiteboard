package com.example.demo.controllers;
import com.example.demo.models.Widget;
import com.example.demo.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    WidgetService service = new WidgetService();
    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets(){
        return service.findAllWidgets();
    }
    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") String wid){
        return service.findWidgetById(wid);
    }
    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid){
        return service.findWidgetsForTopic(tid);
    }
    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") String wid){
        return service.deleteWidget(wid);
    }
    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable("tid") String tid, @RequestBody Widget widget){
        return service.createWidget(tid,widget);
    }
    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") String wid, @RequestBody Widget widget){
        return service.updateWidget(wid, widget);
    }
    @PutMapping("/api/widgets")
    public int updateAllWidgets(@RequestBody List<Widget> widgets){
        return service.updateAllWidgets(widgets);
    }
}
