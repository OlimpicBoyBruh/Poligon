package ru.sberbank.jd.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sberbank.jd.controller.input.GiftInput;
import java.util.UUID;

/**
 * Краткое описание подарка.
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Gift {
    /**
     * Цена подарка.
     */
    private double price;
    /**
     * Содержимое подарка.
     */
    private String content;
    /**
     * Артикул подарка.
     */
    private final String article;

    /**
     * Преобразует из DTO в Gift.
     *
     * @param giftInput DTO объект для преобразования.
     * @return готовый объект.
     */
    public static Gift of(GiftInput giftInput) {
        return new GiftBuilder()
                .article(UUID.randomUUID().toString())
                .price(giftInput.getPrice())
                .content(giftInput.getContent())
                .build();

    }


}
