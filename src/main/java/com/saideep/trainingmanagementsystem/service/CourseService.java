package com.saideep.trainingmanagementsystem.service;

import com.saideep.trainingmanagementsystem.dto.CreateCourseRequest;
import com.saideep.trainingmanagementsystem.dto.CreateCourseResponse;
import com.saideep.trainingmanagementsystem.entity.Course;
import com.saideep.trainingmanagementsystem.entity.Users;
import com.saideep.trainingmanagementsystem.exception.UserNotFoundException;
import com.saideep.trainingmanagementsystem.repository.CourseRepository;
import com.saideep.trainingmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public CreateCourseResponse assignCourseToUser(long id, CreateCourseRequest request)
    {
        Optional<Users> optionalUsers = userRepository.findById(id);

        Users trainer;
        Course course;
        CreateCourseResponse response;

        if (optionalUsers.isPresent())
        {
            trainer = optionalUsers.get();

            course = new Course();

            course.setCourseName(request.getCourseName());
            course.setDescription(request.getDescription());
            course.setTrainer(trainer);
            course.setDurationInHours(request.getDurationInHours());
            course.setActive(true);

            Course savedCourse = courseRepository.save(course);

            response = new CreateCourseResponse();

            response.setCourseId(savedCourse.getId());
            response.setCourseName(savedCourse.getCourseName());
            response.setDescription(savedCourse.getDescription());
            response.setDurationInHours(savedCourse.getDurationInHours());
            response.setTrainerId(savedCourse.getTrainer().getId());
            response.setTrainerName(savedCourse.getTrainer().getFirstName());


        }
        else
        {
            throw new UserNotFoundException("USER ID : " + id + " NOT FOUND");
        }
        return response;

    }

    public List<CreateCourseResponse> getCoursesByTrainerId(long id)
    {
        Optional<Users> optionalUsers = userRepository.findById(id);

        Users user;
        CreateCourseResponse response;
        List<CreateCourseResponse> responses;
        if(optionalUsers.isPresent())
        {
            user = optionalUsers.get(); // we successfully fetched user details by id

            List<Course>courses = user.getCourses(); // in courses we hold course objects for that particular user

             responses = new ArrayList<>();

            for(Course course : courses) {
                response = new CreateCourseResponse();

                response.setCourseId(course.getId());
                response.setCourseName(course.getCourseName());
                response.setDescription(course.getDescription());
                response.setDurationInHours(course.getDurationInHours());
                response.setTrainerId(user.getId());
                response.setTrainerName(user.getFirstName());

                responses.add(response);


            }


        }
        else
        {
            throw new UserNotFoundException("USER ID : " + id + " NOT FOUND");
        }

        return responses;
    }

}
