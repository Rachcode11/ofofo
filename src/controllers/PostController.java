package controllers;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import services.PostService;
import services.PostServiceImpl;

public class PostController {

    private PostService postService = new PostServiceImpl();

    public String createPost(CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";

    }
    public Post viewPost(int postId){
        return postService.viewPost(postId);
    }
}
