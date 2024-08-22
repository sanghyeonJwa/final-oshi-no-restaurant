package kr.oshino.eataku.review.user.repository;

import kr.oshino.eataku.member.entity.Member;
import kr.oshino.eataku.review.user.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    void deleteByReviewNo(int reviewNo);

    int countByMember(Member toMember);

    List<Review> findAllByMember_MemberNo(Long memberNo);
}
