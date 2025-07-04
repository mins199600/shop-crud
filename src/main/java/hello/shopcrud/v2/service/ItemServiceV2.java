package hello.shopcrud.v2.service;

import hello.shopcrud.v2.dto.ItemDtoV2;
import hello.shopcrud.v2.dto.ItemMapperV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.SearchResult;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemServiceV2 {

    private final ItemMapperV2 itemMapperV2;

    public List<ItemDtoV2> itemAllList(){
        log.info("아이템 전체 조회 서비스 들렀다감 ㅅㄱ링~");
        List<ItemDtoV2> findAll = itemMapperV2.itemListFindAll();
        return findAll;
    }

    //상세조회
    public ItemDtoV2 findByOne(int itemId) {
        log.info("단일조회가 되는가??");
        return itemMapperV2.findByOne(itemId);
    }

    //상품수정
    public void update(ItemDtoV2 itemDtoV2) {
        itemMapperV2.updateItem(itemDtoV2);
    }

    //상품등록
    @Transactional
    public List<ItemDtoV2> addItem(ItemDtoV2 itemAdd) {
        itemMapperV2.insertItem(itemAdd);
        reorderItemIds();
        return itemMapperV2.itemListFindAll();
    }

    //상품등록 id 재정렬
    private void reorderItemIds() {
        List<ItemDtoV2> items = itemMapperV2.itemListFindAll();
        int id = 1;
        for(ItemDtoV2 item : items) {
            item.setId(id++);
            itemMapperV2.reorderAfterInsert(item);
        }
    }

    //상품삭제
    @Transactional
    public void deleteItem(int id) {
        itemMapperV2.removeItem(id);
        itemMapperV2.reorderItems();
        log.info("아이템 삭제 성공");
    }

    //상품검색
    public List<ItemDtoV2> search(String keyword) {
        return itemMapperV2.findByKeyword(keyword);
    }
}
