package hello.shopcrud.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper ItemMapper;
    private final ItemMapper itemMapper;

    //상품저장
    public void saveItem(Item item) {
        ItemMapper.save(item);
    }

    //상품 전체 조회
    public List<Item> findItems() {
        return itemMapper.findAll();
    }

}
