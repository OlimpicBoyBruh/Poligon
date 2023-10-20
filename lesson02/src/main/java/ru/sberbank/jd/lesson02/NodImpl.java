package ru.sberbank.jd.lesson02;

/**
 * Класс для реализации интерфейса Nod - определения наибольшего общего делителя двух целых чисел.
 */
public class NodImpl implements Nod {
    public static void main(String[] args) {
        Nod nod = new NodImpl();
        System.out.println(nod.calculate(0, 0));
    }

    private int first;
    private int second;

    /**
     * Вычисляет наибольший делитель у 2 значений с помощью алгоритма Евклида.
     *
     * @param first  Первое значение.
     * @param second Второе значение.
     * @return наибольший общий делитель.
     */
    public int calculate(int first, int second) {

        if (first == 0 && second == 0) {
            return Integer.MAX_VALUE;
        } else if (first < 0 || second < 0) {
            throw new ArithmeticException("Значение не должно быть отрицательным!");
        } else if (first > second) {
            this.first = first;
            this.second = second;
        } else {
            this.first = second;
            this.second = first;
        }
        while (second != 0) {
            int temp = second;
            second = first % second;
            first = temp;
        }
        return first;
    }
}
