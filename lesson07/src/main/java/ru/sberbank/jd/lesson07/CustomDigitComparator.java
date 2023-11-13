package ru.sberbank.jd.lesson07;

import java.util.Comparator;

/**
 * Класс, определяющий порядок четных и нечетных чисел.
 */
public class CustomDigitComparator implements Comparator<Integer> {
    /**
     * Переопределенный метод, определяющий порядок четных и нечетных чисел.
     *
     * @param lhs - левое значение.
     * @param rhs - правое значение.
     * @return int.
     */
    @Override
    public int compare(Integer lhs, Integer rhs) {
        if (lhs == null || rhs == null) {
            throw new IllegalArgumentException();
        }
        if ((lhs % 2 == rhs % 2) || (lhs % 2 != 0) && (rhs % 2 != 0)) {
            return 0;
        } else if (lhs % 2 == 0 && rhs % 2 != 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
