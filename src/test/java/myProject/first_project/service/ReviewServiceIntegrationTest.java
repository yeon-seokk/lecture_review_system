package myProject.first_project.service;

import myProject.first_project.domain.Review;
import myProject.first_project.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest // 스프링 컨테이너와 함께 테스트 실행
@Transactional  // 테스트 완료 후 데이터를 롤백해줌 (DB에 데이터가 남지 않음)

public class ReviewServiceIntegrationTest {

   @Autowired ReviewService reviewService;
   @Autowired ReviewRepository reviewRepository;

   @Test
    void 리뷰등록(){
       // given
       Review review = new Review();
       review.setCourseName("프로그래밍");
       review.setProfessor("정연석");
       review.setComment("정말 좋은 강의입니다.");
       review.setRating(5);

       //when
       Long saveId = reviewService.join(review);

       //then
       Review findReview = reviewService.findOne(saveId).get();
       assertThat(review.getCourseName()).isEqualTo(findReview.getCourseName());
       assertThat(review.getProfessor()).isEqualTo(findReview.getProfessor());
   }
   @Test
    void 중복_리뷰_예외(){

   }

}
