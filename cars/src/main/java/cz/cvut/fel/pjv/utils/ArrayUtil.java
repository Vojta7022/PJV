package cz.cvut.fel.pjv.utils;


public final class ArrayUtil {
    private ArrayUtil() {} // tímto a přidáním final se dá zabránit instancování

    // ˇ Comparable je konkrétní rozhraní
    public static void sort(Comparable[] array) {
        // jelikož nemůžeme vytvořit instanci tak logicky musí všechny metody být statické aby se daly zavolat
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    Comparable temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}