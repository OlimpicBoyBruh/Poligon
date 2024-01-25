package ru.sberbank.jd.controller.input;

import lombok.Data;

/**
 * DTO объект, потом преобразуется в Gift.
 */
@Data
public class GiftInput {
    /**
     * Цена.
     */
    private double price;
    /**
     * Содержимое подарка.
     */
    private String content;

    public GiftInput(double price, String content) {
        this.price = price;
        this.content = content;
    }
}
