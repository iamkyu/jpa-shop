package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * @author Kj Nam
 * @since 2016-08-07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        //Given
        Item item = new Album();
        item.setName("album");

        //When
        itemService.saveItem(item);
        Long id = item.getId();

        //Then
        assertEquals(item, itemService.findOne(id));
    }

    @Test
    public void 중복_상품을_등록하면_기존_상품을_수정한다() throws Exception {
        //Given
        Item item = new Book();
        item.setName("book1");
        itemService.saveItem(item);

        //When
        item.setName("book2");
        itemService.saveItem(item);
        Long id = item.getId();

        //Then
        assertEquals(item.getName(), itemService.findOne(id).getName());
    }
}
