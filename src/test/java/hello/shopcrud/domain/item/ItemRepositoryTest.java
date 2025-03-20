package hello.shopcrud.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach      // 테스트가 끝날 때마다 실행
    void afterEach() {
        itemRepository.clearStore();
    }


    @Test //저장
    void save() {
        //given
        Item item = new Item("itemA",10000,10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        itemRepository.findById(item.getId());
        assertThat(savedItem).isEqualTo(savedItem);
    }


    @Test //전체조회
    void findAll() {
        //given

        //when

        //then
    }


    @Test //상품등록
    void updateItem() {
        //given

        //when

        //then
    }
}