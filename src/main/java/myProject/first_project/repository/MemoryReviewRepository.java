package myProject.first_project.repository;

import myProject.first_project.domain.Review;

import java.util.*;

// 동시성 문제가 고려되지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려

public class MemoryReviewRepository implements ReviewRepository{

    private static Map<Long, Review> store = new HashMap<>();
    private static long sequence = 0L;  // 0,1,2... 번호를 생성해주는 역할

    @Override
    public Review save(Review review) {
        review.setId((++sequence));     // 데이터를 저장할 때마다 ID를 하나씩 올려줌
        store.put(review.getId(), review);
        return review;
    }

    @Override
    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // 결과가 null이어도 감싸서 반환
    }

    @Override
    public List<Review> findAll() {
        return new ArrayList<>(store.values());     // 저장된 모든 리뷰를 리스트로 반환
    }
    public void clearStore() {
        store.clear();  //테스트 시 데이터를 초기화하기 위한 용도
    }
}


//Map 사용: 아직 데이터베이스를 연결하지 않았기 때문에 서버가 떠 있는 동안 메모리에 데이터를 임시로 보관하기 위해 사용.
//Optional : 아아디로 리뷰를 찾을 때, 만약 결과가 없으면 null이 반환될 수 있다. 이를 안전하게 처리하기 위해 optional 감싸줌.
/**
 * Map: 키와 값을 한 쌍으로 묶어서 저장하는 바구니.
 * new HashMap: 이 바구니를 실제로 생성하는 것. HashMap은 동시에 여러 곳에서 데이터를 넣으려 하면 내부 구조 망가짐.
 * sequence 코드도 두명의 사용자가 동시에 실행한다면, 둘다 똑같은 id를 배정받는 참사가 일어난다.
 * ConcurrentHashMap: 내부적으로 알아서 구역별로 잠금을 관리해주기 때문에, 데이터 구조 설계가 꼬이지 않고 안전성이 보장된다.
 */