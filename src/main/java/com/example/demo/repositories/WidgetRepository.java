package com.example.demo.repositories;

import com.example.demo.models.Topic;
import com.example.demo.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {
    //SELECT * FROM widget WHERE topic_id=tid
    @Query(value="SELECT * FROM widget WHERE topic_id=:tid", nativeQuery = true)
    public List<Widget> findWidgetsForTopic(@Param("tid") Integer topicId);
    @Query(value="SELECT * FROM widget", nativeQuery = true)
    public List<Widget> findAllWidgets();
    @Query(value = "SELECT * FROM widget WHERE id=:wid", nativeQuery = true)
    public Widget findWidgetById(@Param("wid") Integer widgetId);
}
