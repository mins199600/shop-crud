package hello.shopcrud.v1.item;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Integer, Item> store = new HashMap<>();
    private static int sequence = 0;

    //상품저장
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }
}
