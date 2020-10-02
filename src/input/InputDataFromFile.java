package input;

import java.io.*;
import java.util.ArrayList;

/** Reads text from file */
public class InputDataFromFile implements InputData {
    @Override
    public String[] readInputDataString(String path) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        File file = new File(path);
        try (FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            String bufferString;
            while ((bufferString = bufferedReader.readLine())!=null) {
                stringArrayList.add(bufferString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArrayList.toArray(new String[]{});
    }
}
