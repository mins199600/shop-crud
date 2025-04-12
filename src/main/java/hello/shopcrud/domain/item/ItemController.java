package hello.shopcrud.domain.item;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    //상품 등록
    @GetMapping("/basic/items/add")
    public String addItem() {
        log.info("아이템 등록 페이지 이동 성공");
        return "basic/addForm";
    }

    //상품 등록 처리
    @PostMapping("/basic/items/add")
    public String addItem(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/basic/items";
    }

    //상품 목록
    @GetMapping("/basic/items")
    public String itemList(){
        log.info("basic/items 시작");
        return "basic/items";
    }

    //상품 상세

    //상품 수정


}
