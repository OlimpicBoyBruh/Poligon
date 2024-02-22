package ru.sberbank.jd.repository;

/**
 * Репозиторий.
 */
public interface Repository<T> {
    /**
     * Добавляет подарок в репозиторий.
     */
    T create(T object);
}
