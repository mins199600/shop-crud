package hello.shopcrud.domain.item;

import lombok.Data;

@Data   //상품객체
public class Item {

    private Long id;    //상품번호
    private String itemName;    //상품이름
    private Integer price;      //상품가격 >> integer을 쓴 이유는 가격이 안 들어 갈수도 있기 때문이다
    private Integer quantity;   //상품수량 >> integer을 쓴 이유는 수량이 없을수도 있기 때문이다


    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
