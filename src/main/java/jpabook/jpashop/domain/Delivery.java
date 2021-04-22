package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    // 배송지 주소
    private String city;
    private String street;
    private String zipCode;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
