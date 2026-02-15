package myProject.first_project.repository;

import myProject.first_project.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaReviewRepository extends JpaRepository<Review, Long>, ReviewRepository {
    // 아무것도 적지 않아도 save, findAll 등을 바로 쓸 수 있다.
}
