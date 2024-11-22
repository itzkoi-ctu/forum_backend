package org.example.miniforum.dataInitial;


import org.example.miniforum.model.*;
import org.example.miniforum.repository.CategoryRepository;
import org.example.miniforum.repository.CommentRepository;
import org.example.miniforum.repository.PostRepository;
import org.example.miniforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CategoryRepository categoryRepository;

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


        Category ct1 = new Category();
        ct1.setName("Thời trang");
        Category ct2 = new Category();
        ct2.setName("sách");
        Category ct3 = new Category();
        ct3.setName("Đồ công nghệ");
        Category ct4 = new Category();
        ct4.setName("Dụng cụ, thiết bị");
        Category ct5 = new Category();
        ct5.setName("Thời trang");
        Category ct6 = new Category();
        ct6.setName("Khác");

        List<Category> cts = new ArrayList<>();
        cts.add(ct1);
        cts.add(ct2);
        cts.add(ct3);
        cts.add(ct4);
        cts.add(ct5);
        cts.add(ct6);
        categoryRepository.saveAll(cts);

        Set<Category> categories = new HashSet<>();
        categories.add(categoryRepository.findById(1).get());

        Post post = Post.builder()
                .images(images)
                .title("Bán đồ hốt rác")
                .content("hàng chính hãng China chất liệu nhựa cao cấp")
                .price(45000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(categories)
                .build();

        Set<Category> cgr = new HashSet<>();
        cgr.add(categoryRepository.findById(3).get());
        Post post2 = Post.builder()
                .title("tìm gia sư")
                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
                        "lương thử việc 100k/h")
                .price(450000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post3 = Post.builder()
                .title("Tìm gia sư dạy Toán lớp 9")
                .content("Cần tìm gia sư dạy kèm Toán lớp 9 tại nhà cho bé 14 tuổi. Yêu cầu: gia sư có kinh nghiệm, giờ dạy từ 19h-21h các ngày trong tuần. Lương 120k/giờ.")
                .price(120000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post4 = Post.builder()
                .title("Cần người trông trẻ buổi tối")
                .content("Cần người trông trẻ tại nhà vào buổi tối cho bé 20 tháng tuổi. Yêu cầu: nữ, tuổi từ 18-25, có kinh nghiệm. Lương 100k/giờ.")
                .price(100000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post5 = Post.builder()
                .title("Tìm gia sư tiếng Anh giao tiếp")
                .content("Cần tìm gia sư dạy tiếng Anh giao tiếp tại nhà cho người lớn. Yêu cầu: phát âm chuẩn, linh hoạt thời gian dạy. Mức lương 150k/giờ.")
                .price(150000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post6 = Post.builder()
                .title("Tìm gia sư dạy Piano")
                .content("Cần gia sư dạy đàn piano cơ bản cho trẻ 10 tuổi. Lịch học cuối tuần, thời gian linh hoạt. Lương 200k/giờ.")
                .price(200000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post7 = Post.builder()
                .title("Cần tìm người hỗ trợ làm bài tập lập trình")
                .content("Cần hỗ trợ làm bài tập Java cơ bản. Học viên cần hướng dẫn qua Zoom hoặc tại nhà. Lương 250k/bài.")
                .price(250000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post8 = Post.builder()
                .title("Cần gia sư kèm môn Hóa lớp 8")
                .content("Tìm gia sư dạy kèm Hóa học lớp 8 cho học sinh yếu môn Hóa. Dạy tại nhà, ưu tiên giáo viên có kinh nghiệm sư phạm. Lương 180k/giờ.")
                .price(180000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post9 = Post.builder()
                .title("Tìm đối tác trao đổi sách cũ")
                .content("Tôi cần trao đổi sách cũ (tiểu thuyết, sách học thuật) tại khu vực quận 5. Ai có nhu cầu vui lòng liên hệ để trao đổi thêm.")
                .price(0L) // Miễn phí
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();

        Post post10 = Post.builder()
                .title("Bán xe đạp cũ giá rẻ")
                .content("Bán xe đạp cũ 90% mới, phù hợp cho học sinh, sinh viên. Giá chỉ 800k, liên hệ trực tiếp để xem xe tại quận 7.")
                .price(800000L)
                .votes(0L)
                .comments(0L)
                .user(user)
                .categories(cgr)
                .build();


        List<Post> pl = new ArrayList<>();
        pl.add(post4);
        pl.add(post5);

        pl.add(post6);

        pl.add(post7);

        pl.add(post8);
        pl.add(post9);
        pl.add(post10);




        postRepository.saveAll(pl);
        postRepository.save(post3);
        postRepository.save(post2);


//        Post post3 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post3);
//        Post post4 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post4);
//        Post post5 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post5);
//        Post post6 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post6);
//        Post post7 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post7);
//        Post post8 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post8);
//        Post post9 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post9);
//        Post post10 = Post.builder()
//                .title("tìm gia sư")
//                .content("cần tìm gia sư hoặc người trông trẻ cho bé 240 tháng tuổi vào ban đêm, yêu cầu nữ 16 đến 25t, cao trên 1m55 nặng dưới 60kg, ưu tiên ngoại hình" +
//                        "lương thử việc 100k/h")
//                .price(450000L)
//                .votes(0L)
//                .comments(0L)
//                .user(user)
//                .categories(cgr)
//                .build();
//        postRepository.save(post10);
        for(Image img : images) {
            img.setPost(post);
        }

        Set<Post> ps = new HashSet<Post>();
        ps.add(post);
        ct1.setPosts(ps);





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