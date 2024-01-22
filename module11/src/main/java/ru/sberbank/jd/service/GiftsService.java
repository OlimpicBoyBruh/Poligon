package ru.sberbank.jd.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.controller.input.GiftInput;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.repository.GiftsRepository;

/**
 * Класс для взаимодействия с репозиторием.
 */
@Service
public class GiftsService {
    /**
     * Репозиторий подарков.
     */
    private final GiftsRepository giftsRepository;

    /**
     * Инициализирует репозиторий.
     *
     * @param giftsRepository репозиторий подарков.
     */
    public GiftsService(GiftsRepository giftsRepository) {
        this.giftsRepository = giftsRepository;
    }

    /**
     * Добавляет в репозиторий.
     *
     * @param giftInput DTO объект.
     * @return новый подарок по артикулу.
     */
    public Gift addGift(@NonNull GiftInput giftInput) {
        return giftsRepository.create(Gift.of(giftInput));
    }

    /**
     * Возвращает подарок из репозитория.
     *
     * @param article артикул.
     * @return подарок по артикулу.
     */
    public Gift getGift(String article) {
        return giftsRepository.getByArticle(article);
    }

    /**
     * Обновляет подарок, устанавливает новую цену.
     *
     * @param article артикул.
     * @param price   новая цена.
     * @return обновленный подарок.
     */
    public Gift udpdateGift(String article, double price) {
        Gift gift = giftsRepository.getByArticle(article);
        gift.setPrice(price);
        return giftsRepository.getByArticle(article);
    }

    /**
     * Удаляет подарок из репозитория после продажи.
     *
     * @param article артикул.
     * @return удаленный подарок.
     */
    public Gift selling(String article) {
        return giftsRepository.remove(article);
    }
}
