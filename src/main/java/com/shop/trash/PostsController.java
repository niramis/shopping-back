//package com.shop.controllers;
//
//import com.shop.model.Post;
//import com.shop.model.Tag;
//import com.shop.repository.PostRepository;
//import com.shop.repository.TagRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "posts")
//public class PostsController {
//    @Autowired
//    private TagRepository tagRepository;
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @GetMapping(path = "/delete")
//    public void delete() {
//        postRepository.deleteAllInBatch();
//        tagRepository.deleteAllInBatch();
//    }
//
//    @GetMapping(path = "/post")
//    public List<Post> getAllPosts() {
//        return postRepository.findAll();
//    }
//
//    @GetMapping(path = "tags")
//    public List<Tag> getAllTags() {
//        return tagRepository.findAll();
//    }
//
//    @PostMapping(path="savetag")
//    public Tag saveTag(Tag tag){
//        return tagRepository.save(tag);
//    }
//
//    @GetMapping(path = "save")
//    public void save() {
//        // Create a Post
//        Post post = new Post("Hibernate Many to Many Example with Spring Boot",
//                "Learn how to map a many to many relationship using hibernate",
//                "Entire Post content with Sample code");
//
//        // Create two tags
//        Tag tag1 = new Tag("Spring Boot");
//        Tag tag2 = new Tag("Hibernate");
//
//
//        // Add tag references in the post
//        post.getTags().add(tag1);
//        post.getTags().add(tag2);
//
//        // Add post reference in the tags
//        tag1.getPosts().add(post);
//        tag2.getPosts().add(post);
//
//        postRepository.save(post);
//    }
//
//}
