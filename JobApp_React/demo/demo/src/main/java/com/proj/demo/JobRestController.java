package com.proj.demo;

import com.proj.demo.model.Jobpost;
import com.proj.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<Jobpost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public Jobpost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<Jobpost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

//    @PostMapping("jobPost")
//    public void addJob(@RequestBody Jobpost jobPost){
//        service.addJob(jobPost);
//    }
    @PostMapping("jobPost")
    public Jobpost addJob(@RequestBody Jobpost jobPost){
        service.addJob(jobPost);
//        return jobPost;
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public Jobpost updateJob(@RequestBody Jobpost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }
}
