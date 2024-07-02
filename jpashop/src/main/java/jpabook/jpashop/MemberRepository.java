package jpabook.jpashop;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        // 저장을 하고 나면, side effect 성을 일으키는 커맨드이기 때문에 리턴값을 잘 안만듦.
        // 대신에 id 정도는 있으면 다음에 다시 조회할 수 있으니까
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }



}
