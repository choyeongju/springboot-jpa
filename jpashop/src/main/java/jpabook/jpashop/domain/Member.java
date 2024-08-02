package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Embedded //내장타입
    private Address address;

    @OneToMany(mappedBy = "member")
    //연관관계의 주인이 아니다! order 테이블에 있는 member 필드에 의해서 맵핑된 거울일 뿐.
    // 읽기영역: 여기에 값을 넣는다고 해서 FK가 변경되지는 않는다.
    private List<Order> orders= new ArrayList<>();
}