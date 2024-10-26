package org.example.miniforum.dataInitial;

import org.example.miniforum.model.Comment;
import org.example.miniforum.model.Image;
import org.example.miniforum.model.Post;
import org.example.miniforum.model.User;
import org.example.miniforum.repository.CommentRepository;
import org.example.miniforum.repository.PostRepository;
import org.example.miniforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {



        User user = User.builder()
                .username("luc tran")
                .email("tluc509@gmail.com")
                .password("123456")
                .accountName("anh luc rach gia")
                .build();
        userRepository.save(user);

        Image image = new Image();
        image.setImageUrl("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcTxJIoVWWupMZmd8zvRJnUVCPWHho2Y4QHIDErylcMjb-X_WhTNgbp-Sr9fDJd-Mqu-9eAU0VqepffxPC08RaM3w8NU8gzKE5cnFAfHOgT9INKCkR1sSZjeaaxVlQGDeShly1Ie6A&usqp=CAc");


        List<Image> images = new ArrayList<>();
        images.add(image);

        Post post = Post.builder()
                .images(images)
                .title("Bán đồ hốt rác")
                .content("hàng chính hãng China chất liệu nhựa cao cấp")
                .price(45000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .build();

        for(Image img : images) {
            img.setPost(post);
        }

        postRepository.save(post);

        Comment comment = Comment.builder()
                .content("cho xin sdt")
                .post(post)
                .user(user)
                .build();
        commentRepository.save(comment);
//
//
//        Post post1 = postRepository.findById(post.getId()).get();
//        post1.setComment(comment);
//        postRepository.save(post1);
    }
}
