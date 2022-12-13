package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostServiceImplTest {
private PostService postService;
private CreatePostRequest createPostRequest;
    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
        createPostRequest = new CreatePostRequest();
    }
    @Test
    public void createPostTest(){
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAll().size());
    }
    @Test
    public void viewPostTest(){
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAll().size());

        Post post = postService.viewPost(1);
        assertEquals("New Post", post.getTitle());
        assertEquals("Egusi is my best soup", post.getBody());
        assertNotNull(post.getCreationTime());

    }
    @Test
    public void deletePostTest(){
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAll().size());

        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(2, postService.viewAll().size());

        postService.deletePost(1);
        assertEquals(1,postService.viewAll().size());
    }
}