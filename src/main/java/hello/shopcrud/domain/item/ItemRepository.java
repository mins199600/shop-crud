package hello.shopcrud.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    //검색
    public Item findById(Long id) {
        return store.get(id);
    }

    //전체조회
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    //상품등록
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());      //상품 이름 등록
        findItem.setPrice(updateParam.getPrice());            //상품 가격 등록
        findItem.setQuantity(updateParam.getQuantity());      //상품 수량 등록
    }

    //상품 전체 삭제
    public void clearStore() {
        store.clear();
    }
}
