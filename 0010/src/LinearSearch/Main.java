package LinearSearch;

public class Main {

    public static void main(String[] args) {

        LinearSearch ls = new LinearSearch();

        int size = InputValidation.inputInteger(
                "Enter the number of array: ", 0, Integer.MAX_VALUE);

        String value = InputValidation.inputString("Enter search value: ");

        ls.generateArray(size);
        ls.displayArray("The array:");

        int index = ls.searchByUserInput(value);
        ls.displayIndexOfValue(value, index);
    }
}
