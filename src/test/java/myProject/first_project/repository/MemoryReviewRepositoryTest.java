package myProject.first_project.repository;

import myProject.first_project.domain.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryReviewRepositoryTest {

    MemoryReviewRepository repository = new MemoryReviewRepository();

    // 각 테스트가 끝날 때마다 저장소를 깔끔하게 비워준다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save(){
        //given: 이런 상황이 주어졌을 때
        Review review = new Review();
        review.setCourseName("객체지향프로그래밍");
        review.setProfessor("심철준");
        review.setRating(5);
        review.setComment("성적을 엄청 잘 주세요!");

        //when: 이걸 실행하면
        repository.save(review);

        //then: 결과가 이래야 한다
        Review result = repository.findById(review.getId()).get();
        assertThat(result).isEqualTo(review);   // 저장한 리뷰와 찾은 리뷰가 같은지 확인

    }
    @Test
    public void findAll(){
        //given: 리뷰 2개를 저장했을 때
        Review review1 = new Review();
        review1.setCourseName("자료구조");
        repository.save(review1);

        Review review2 = new Review();
        review2.setCourseName("알고리즘");
        repository.save(review2);

        //when: 전체 목록을 조회하면
        List<Review> result = repository.findAll();

        //then: 개수가 2개여야 한다.
        assertThat(result.size()).isEqualTo(2);
    }
}
