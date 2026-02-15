package myProject.first_project;


import myProject.first_project.aop.LogTraceAop;
import myProject.first_project.repository.ReviewRepository;
import myProject.first_project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final ReviewRepository reviewRepository;

    @Autowired  //  스프링이 자동으로 만든 스프링 데이터 JPA 구현체를 여기에 주입해준다.
    public SpringConfig(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Bean
    public ReviewService reviewService() {
        //ReviewService가 ReviewRepository를 사용할 수 있게 주입해준다.
        return new ReviewService(reviewRepository);
    }
    // @Bean reviewRepository() 메서드는 이제 필요 없다.
    //  스프링 데이터 JPA가 자동으로 빈을 등록해주기 때문이다.


}

