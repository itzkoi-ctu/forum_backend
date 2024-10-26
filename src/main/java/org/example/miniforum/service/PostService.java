package org.example.miniforum.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.miniforum.dto.request.PostRequest;
import org.example.miniforum.dto.response.PostResponse;
import org.example.miniforum.mapper.ImageMapper;
import org.example.miniforum.mapper.PostMapper;
import org.example.miniforum.model.Image;
import org.example.miniforum.model.Post;
import org.example.miniforum.repository.ImageRepository;
import org.example.miniforum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Transactional
    public Post createPost(PostRequest postRequest) {
        Post post = new Post();
        post = postMapper.toPost(postRequest);

        List<Image> imageEntities = new ArrayList<>();
        for(MultipartFile imageFile  : postRequest.getImages()) {
            try{
                String imageUrl = cloudinaryService.uploadImage(imageFile);
                Image image = new Image();
                image.setImageUrl(imageUrl);
                image.setPost(post);
                imageEntities.add(image);
            }catch(IOException e){
                log.error("====> image service error: {}",e.getMessage());
            }

        }
        // image list auto save to image table
        post.setImages(imageEntities);
        return postRepository.save(post);
    }

    public List<PostResponse> getAllPosts() {

        List<Post> posts = postRepository.findAll();

        List<PostResponse> responses = new ArrayList<>();

        for (Post post : posts) {
            PostResponse postResponse = postMapper.toPostResponse(post);
            log.info("=======> {}",postResponse.toString());
            responses.add(postResponse);
        }

        return responses;
    }


    public PostResponse getPostById(int id) {
        return postMapper.toPostResponse(postRepository.findById(id).get());
    }

    public void likePost(int postId) {
        Post post = postRepository.findById(postId).get();
        post.addVote();
        postRepository.save(post);
    }
}
