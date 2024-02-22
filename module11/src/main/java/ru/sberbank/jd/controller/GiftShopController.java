package ru.sberbank.jd.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.controller.input.GiftInput;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.service.GiftsService;

import java.util.List;

/**
 * RestController обрабатывает PUT, GET, DELETE, POST запросы по пути /catalog.
 */
@RestController
@RequestMapping(path = "/catalog", produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
@Slf4j
public class GiftShopController {
    private final GiftsService giftsService;

    /**
     * Возвращает все подарки по адресу, пример - <a href="http://localhost:8080/catalog/">...</a>
     *
     * @return список подарков.
     */

    @GetMapping
    public List<Gift> catalog() {
        return giftsService.getAllGift();
    }

    /**
     * Возвращает подарок а адресу, пример - <a href="http://localhost:8080/catalog/">...</a>{article}
     *
     * @param article артикул подарка.
     * @return подарок по заданному артикулу.
     */
    @GetMapping("/{article}")
    public Gift buyGift(@PathVariable("article") String article) {

        Gift gift = giftsService.getGift(article);
        return gift;
    }

    /**
     * Создает подарок а адресу, пример - <a href="http://localhost:8080/catalog/add">...</a>
     * Параметры подарка передаются через body.
     *
     * @param giftInput промежуточная форма подарка.
     * @return подарок после преобразования.
     */
    @PostMapping(value = "/add")
    public Gift addGift(@RequestBody GiftInput giftInput) {
        return giftsService.addGift(giftInput);
    }

    /**
     * Обновляет цену подарка по адресу, пример - <a href="http://localhost:8080/catalog/update">...</a>
     *
     * @param article артикул подарка.
     * @param price   новая цена подарка.
     * @return обновленный подарок.
     */
    @PutMapping(value = "/update")
    @ResponseBody
    public Gift updatePrice(@RequestParam("article") String article, @RequestParam("price") double price) {
        return giftsService.udpdateGift(article, price);
    }

    /**
     * Удаляет подарок из репозитория после продажи, пример - <a href="http://localhost:8080/catalog/update">...</a>
     *
     * @param article артикул подарка.
     * @return проданный подарок.
     */
    @DeleteMapping("/sell")
    @ResponseBody
    public Gift giftSale(@RequestParam("article") String article) {
        return giftsService.selling(article);
    }

}
