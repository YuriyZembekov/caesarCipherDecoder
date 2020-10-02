package output;


/** Prints decoded data to the console*/
public class OutputDataToConsole implements OutputData {
    @Override
    public void outputDataStrings(String... strings) {
        for (String stringToConsole: strings ) {
            System.out.println(stringToConsole);
        }
        System.out.println();
    }
}
