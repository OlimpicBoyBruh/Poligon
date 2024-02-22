package ru.sberbank.jd.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.model.Gift;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для хранения подарков.
 */
@Slf4j
@Repository
public class GiftShopRepository implements GiftsRepository {
    /**
     * Кэш подарок.
     */
    private Map<String, Gift> storage = new HashMap<>();

    /**
     * Добавляет подарок в репозиторий.
     *
     * @param gift созданный подарок.
     * @return этот же подарок.
     */
    @Override
    public Gift create(Gift gift) {
        log.info("Invoke create," + gift);
        storage.put(gift.getArticle(), gift);
        return gift;
    }

    /**
     * Возвращает подарок по артикулу.
     *
     * @param article артикул подарка.
     * @return найденный подарок.
     */
    @Override
    public Gift getByArticle(String article) {
        log.info("Invoke getByArticle," + storage.get(article));
        return storage.get(article);
    }

    /**
     * Обновляет цену подарка по заданному артикулу.
     *
     * @param article артикул.
     * @param price   новая цена.
     * @return обновленный подарок.
     */
    @Override
    public Gift update(String article, double price) {
        log.info("Invoke update," + getByArticle(article));
        getByArticle(article).setPrice(price);
        return getByArticle(article);
    }

    /**
     * Удаляет подарка из репозитория после продажи.
     *
     * @param article артикул.
     * @return проданный подарок.
     */
    @Override
    public Gift remove(String article) {
        log.info("Invoke remove," + getByArticle(article));
        return storage.remove(article);
    }

    /**
     * Возвращает все подарки.
     *
     * @return список подарков.
     */
    @Override
    public List<Gift> catalog() {
        return new ArrayList<>(storage.values());
    }
}
