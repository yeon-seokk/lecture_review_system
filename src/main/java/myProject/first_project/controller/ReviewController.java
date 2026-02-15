package myProject.first_project.controller;

import myProject.first_project.domain.Review;
import myProject.first_project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    // 생성자 주입: 스프링 빈으로 등록된 ReviewService를 가져온다.
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 등록 폼 화면으로 이동
    @GetMapping("/reviews/new")
    public String createForm(){
        return "reviews/createReviewForm";
    }

    @PostMapping("/reviews/new")
    public String create(ReviewForm form){
        Review review = new Review();

        review.setCourseName(form.getCourseName());
        review.setProfessor(form.getProfessor());
        review.setRating(form.getRating());
        review.setComment(form.getComment());

        reviewService.join(review);

        return "redirect:/"; // 저장 후 홈 화면으로 이동
    }

    @GetMapping("/reviews")
    public String list(Model model){
        List<Review> reviews = reviewService.findReviews();
        model.addAttribute("reviews", reviews); //  HTML에 'reviews'라는 이름으로 데이터를 넘김
        return "reviews/reviewList";

    }
}
