package com.proj.demo.service;

import com.proj.demo.model.Jobpost;
import com.proj.demo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(Jobpost jobPost){
        repo.save(jobPost);
    }

    public List<Jobpost> getAllJobs(){
        return repo.findAll();
    }

    public Jobpost getJob(int postId){
        return repo.findById(postId).orElse(new Jobpost());
    }

    public void updateJob(Jobpost jobPost){
        repo.save(jobPost);
    }

    public void deleteJob(int postId){
        repo.deleteById(postId);
    }

    public void load(){
        List<Jobpost> jobs = new ArrayList<>(Arrays.asList(
                new Jobpost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new Jobpost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),
                new Jobpost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
                new Jobpost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
                new Jobpost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));

        repo.saveAll(jobs);
    }

    public List<Jobpost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
