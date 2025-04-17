package hello.shopcrud.v1.item;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        log.info("상품 등록 완료");
        return "redirect:/basic/items";
    }

    //상품 목록
    @GetMapping("/basic/items")
    public String itemList(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        log.info("basic/items 시작");
        return "basic/items";
    }

    //상품 상세
    @GetMapping("/basic/items/{itemId}")
    public String itemDetail(@PathVariable int itemId, Model model) {
        Item item = itemService.findByItemId(itemId);
        model.addAttribute("item",item);
        log.info("상품 상세 보기 시작");
        return "basic/item";
    }

    //상품 수정 페이지 이동
    @GetMapping("/basic/items/{itemId}/edit")
    public String showEditForm(@PathVariable int itemId, Model model) {
        Item item = itemService.findByItemId(itemId);
        model.addAttribute("item", item);
        log.info("상품 수정 페이지 이동 성공");
        return "basic/editForm";
    }

    //상품 수정
    @PostMapping("/basic/items/{itemId}/edit")
    public String updateItem(@PathVariable int itemId, @ModelAttribute Item item) {
        itemService.updateItem(itemId, item);
        return "redirect:/basic/items/" + itemId;
    }

}
