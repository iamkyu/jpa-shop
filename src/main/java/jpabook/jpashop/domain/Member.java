package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2016-08-03
 */
@Entity
public class Member {

    @Id
    @GeneratedValue // @GeneratedValue 기본값은 AUTO. DBMS 방언에 따라 자동 선택됨.
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address adress;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}