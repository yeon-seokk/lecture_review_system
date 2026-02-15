package myProject.first_project.service;

import myProject.first_project.domain.Review;
import myProject.first_project.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

public class ReviewService {

    private final ReviewRepository reviewRepository;

    //  생성자를 통해 리포지토리를 외부에서 넣어줌 (DI개념)
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * 강의 리뷰 등록
     */
    public Long join(Review review){
        validateDuplicateReview(review);
        reviewRepository.save(review);
        return review.getId();
    }

    private void validateDuplicateReview(Review review){
        // 같은 강의에 같은 교수님 리뷰는 중복으로 간주
        reviewRepository.findAll().stream()
                .filter(r -> r.getCourseName().equals(review.getCourseName())
                        && r.getProfessor().equals(review.getProfessor()))
                .findAny()
                .ifPresent((r ->{
                    throw new IllegalStateException("이미 존재하는 리뷰입니다.");
                }));
    }

    /**
     * 전체 리뷰 조회
     */
    public List<Review> findReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> findOne(Long reviewId){
        return reviewRepository.findById(reviewId);
    }
}
