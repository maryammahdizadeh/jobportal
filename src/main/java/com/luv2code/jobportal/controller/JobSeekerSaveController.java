package com.luv2code.jobportal.controller;


import com.luv2code.jobportal.service.JobPostActivityService;
import com.luv2code.jobportal.service.JobSeekerProfileService;
import com.luv2code.jobportal.service.JobSeekerSaveService;
import com.luv2code.jobportal.service.UsersService;
import org.springframework.stereotype.Controller;

@Controller
public class JobSeekerSaveController {

    private final UsersService usersService;
    private final JobSeekerProfileService jobSeekerProfileService;
    private final JobPostActivityService jobPostActivityService;
    private final JobSeekerSaveService jobSeekerSaveService;

    public JobSeekerSaveController(UsersService usersService, JobSeekerProfileService jobSeekerProfileService, JobPostActivityService jobPostActivityService, JobSeekerSaveService jobSeekerSaveService) {
        this.usersService = usersService;
        this.jobSeekerProfileService = jobSeekerProfileService;
        this.jobPostActivityService = jobPostActivityService;
        this.jobSeekerSaveService = jobSeekerSaveService;
    }
}
