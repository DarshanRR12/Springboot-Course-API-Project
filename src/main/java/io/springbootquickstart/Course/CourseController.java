package io.springbootquickstart.Course;

import io.springbootquickstart.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/topics/{TopicId}/courses")
    public List<Course> getAllTopics(@PathVariable String id){
        return courseService.getAllCourses(id);
    }
    @GetMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getTopic(@PathVariable String id){
        return courseService.getCourse(id);
    }
    @PostMapping("/topics/{topicsId}/courses")
    public void addTopic(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateTopic(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
