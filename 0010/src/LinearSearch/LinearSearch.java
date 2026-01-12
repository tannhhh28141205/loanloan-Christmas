

package LinearSearch;


import java.util.Random;

import java.util.Random;

public class LinearSearch {

    private int[] arr;

    // Tạo mảng
    public void generateArray(int size) {
        arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(size + size + 1) - size;
        }
    }

    // Hiển thị mảng
    public void displayArray(String msg) {
        System.out.print(msg + " [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Thuật toán linear search
    private int linearSearch(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Xử lý input người dùng
    public int searchByUserInput(String input) {
        try {
            int value = Integer.parseInt(input);
            return linearSearch(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Hiển thị kết quả
    public void displayIndexOfValue(String value, int index) {
        if (index == -1) {
            System.out.println("Not found any value match with search number");
        } else {
            System.out.printf("Found %s at index: %d%n", value, index);
        }
    }
}
