package myProject.first_project.service;

import myProject.first_project.domain.Review;
import myProject.first_project.repository.MemoryReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {
    ReviewService reviewService;
    MemoryReviewRepository reviewRepository;

    @BeforeEach
    public void beforeEach(){
        //  테스트를 시작하기 전마다 새로운 객체를 생성하여 독립성을 보장한다.(DI)
        reviewRepository = new MemoryReviewRepository();
        reviewService = new ReviewService(reviewRepository);
    }

    @AfterEach
    public void afterEach(){
        reviewRepository.clearStore();
    }

    @Test
    void 리뷰등록() {
        //given
        Review review = new Review();
        review.setCourseName("웹프로그래밍");
        review.setProfessor("박소영");

        //when
        Long saveId = reviewService.join(review);

        //then
        Review findReview = reviewService.findOne(saveId).get();
        assertThat(review.getCourseName()).isEqualTo(findReview.getCourseName());
    }

    @Test
    void 중복_리뷰_예외() {
        //given
        Review review1 = new Review();
        review1.setCourseName("데이터베이스");
        review1.setProfessor("이철수");

        Review review2 = new Review();
        review2.setCourseName("데이터베이스");
        review2.setProfessor("이철수");

        //when
        reviewService.join(review1);

        //then
        //똑같은 강의/교수 리뷰를 등록하면 예외가 발생해야한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> reviewService.join(review2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 리뷰입니다.");
    }

    @Test
    void findOne() {
    }
}