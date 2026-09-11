package com.proj.demo.repo;


import com.proj.demo.model.Jobpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<Jobpost, Integer> {
    List<Jobpost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}
//
//public List<Jobpost> getAllJobs(){
//    return jobs;
//}
//
//public void addJob(Jobpost job){
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//public Jobpost getJob(int postId){
//    for(Jobpost job : jobs){
//        if(job.getPostId() == postId){
//            return job;
//        }
//    }
//    return null;
//}
//
//public void updateJob(Jobpost jobPost){
//    for(Jobpost jobPosts : jobs){
//        if(jobPosts.getPostId() == jobPost.getPostId()){
//            jobPosts.setPostProfile(jobPost.getPostProfile());
//            jobPosts.setPostDesc(jobPost.getPostDesc());
//            jobPosts.setPostTechStack(jobPost.getPostTechStack());
//            jobPosts.setReqExperience(jobPost.getReqExperience());
//        }
//    }
//}
//
//public void deleteJob(int postId){
//    for(int i=0;i<jobs.size();i++){
//        if(jobs.get(i).getPostId() == postId){
//            jobs.remove(i);
//        }
//    }
//}