package com.example.demo.repositories;
import com.example.demo.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
    @Query(value="SELECT * FROM topic", nativeQuery = true)
    public List<Topic> findAllTopics();
    @Query(value="SELECT * FROM topic WHERE lesson_id=:lid", nativeQuery = true)
    public List<Topic> findTopicsForLesson(@Param("lid") String lessonId);
    @Query(value="SELECT * FROM topic WHERE id=:tid", nativeQuery = true)
    public Topic findTopicById(@Param("tid") Integer topicId);
}
