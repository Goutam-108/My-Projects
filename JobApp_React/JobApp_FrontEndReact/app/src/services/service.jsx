import config from "./config"
import axios  from 'axios';

export async function jobs(){
    const url = config.BaseUrl + "/jobPosts"
    const response  = await axios.get(url)
    return response.data
}

export async function deletePost(id){
    const url = config.BaseUrl + `/jobPost/${id}`
    const response = await axios.delete(url)
    console.log(response.data)
}

export async function getPostForEdit(id){
    const url = config.BaseUrl + `/jobPost/${id}`
    const response = await axios.get(url)
    return response.data
}

export async function editPost(Jobpost){
    const url = config.BaseUrl + `/jobPost`
    const response = await axios.put(url, Jobpost);
    return response.data
}

export async function createJob(Jobpost){
    const url = config.BaseUrl + `/jobPost`
    const response = await axios.post(url, Jobpost)
    return response.data
}

