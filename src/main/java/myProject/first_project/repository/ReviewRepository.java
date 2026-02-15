package myProject.first_project.repository;

import myProject.first_project.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    Review save(Review review);         // 리뷰 저장
    Optional<Review> findById(Long id); // ID로 리뷰 찾기
    List<Review> findAll();             // 모든 리뷰 목록 조회
}
