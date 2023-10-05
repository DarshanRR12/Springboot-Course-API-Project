package io.springbootquickstart.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        // what we did here is we connected the database and run a query and got all the topics
        // and converted the rows into topic instances and got it back.
        return new ArrayList<>(courseRepository.findByTopicId(topicId));
    }

    public Optional<Course> getCourse(String id){
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        //topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for(int i = 0; i < topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
