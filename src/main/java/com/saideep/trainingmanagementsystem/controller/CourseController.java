package com.saideep.trainingmanagementsystem.controller;

import com.saideep.trainingmanagementsystem.dto.CreateCourseRequest;
import com.saideep.trainingmanagementsystem.dto.CreateCourseResponse;
import com.saideep.trainingmanagementsystem.dto.CreateUserResponse;
import com.saideep.trainingmanagementsystem.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService CourseService)
    {
        this.courseService = CourseService;
    }

    @PostMapping("/{id}")
    public CreateCourseResponse assignCourseToUser( @PathVariable long id ,@RequestBody CreateCourseRequest request)
    {
        return courseService.assignCourseToUser(id,request);
    }

    @GetMapping("/{id}")
    public List<CreateCourseResponse> getCoursesByTrainerId(@PathVariable long id)
    {
        return courseService.getCoursesByTrainerId(id);
    }




}
