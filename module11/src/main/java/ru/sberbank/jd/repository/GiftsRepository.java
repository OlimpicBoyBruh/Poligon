package ru.sberbank.jd.repository;

import ru.sberbank.jd.model.Gift;

import java.util.List;

/**
 * Репозиторий подарков.
 */
public interface GiftsRepository extends Repository<Gift> {

    /**
     * Возвращает подарок по артикулу.
     *
     * @param article артикул подарка.
     * @return найденный подарок.
     */
    Gift getByArticle(String article);


    /**
     * Обновляет цену подарка по заданному артикулу.
     *
     * @param article артикул.
     * @param price   новая цена.
     * @return обновленный подарок.
     */
    Gift update(String article, double price);

    /**
     * Удаляет подарка из репозитория после продажи.
     *
     * @param article артикул.
     * @return проданный подарок.
     */
    Gift remove(String article);

    List<Gift> catalog();
}
