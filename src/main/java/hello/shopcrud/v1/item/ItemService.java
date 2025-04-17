package hello.shopcrud.v1.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper itemMapper;


    //상품저장
    public void saveItem(Item item) {
        itemMapper.save(item);
    }

    //상품 전체 조회
    public List<Item> findItems() {
        return itemMapper.findAll();
    }

    //상품 상세 조회
    public Item findByItemId(int id) {
        return itemMapper.findById(id);
    }

    //상품수정
    public void updateItem(int itemId, Item item) {
        itemMapper.update(itemId, item);
    }
}
