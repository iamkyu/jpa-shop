package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

/**
 * @author Kj Nam
 * @since 2016-08-06
 */
@Embeddable
public class Address {

    private String city;
    private String steet;
    private String zipcode;

    public Address() {
    }

    public Address(String city, String steet, String zipcode) {
        this.city = city;
        this.steet = steet;
        this.zipcode = zipcode;
    }
}
