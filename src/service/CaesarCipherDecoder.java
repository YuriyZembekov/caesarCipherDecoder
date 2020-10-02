package service;

import input.InputData;
import input.InputDataFromFile;
import output.OutputData;
import output.OutputDataToConsole;
import service.decoder.Decoder;
import service.decoder.StringDecoderRussianLanguage;

/** Create variables needed for the application */
public class CaesarCipherDecoder {

    private Decoder decoder;
    private InputData inputData;
    private OutputData outputData;
    private final static String PATH_INPUT = "src/resources/input.txt";

    /** Defines implementations of interfaces*/
    public CaesarCipherDecoder() {
        decoder = new StringDecoderRussianLanguage();
        inputData = new InputDataFromFile();
        outputData = new OutputDataToConsole();
    }

    /** Implements the main logic of the application */
    public void startDecode() {
        String[] dataCode = inputData.readInputDataString(PATH_INPUT);
        String[] dataEncode = new String[dataCode.length];

        for (int i = 1; i <= 32; i++) {
            for (int j = 0; j < dataCode.length; j++) {
                dataEncode[j] = decoder.shiftRightByNumberOfCharacter(dataCode[j], i);
            }
            outputData.outputDataStrings(dataEncode);
        }
    }

    /** Creates an instance of the class and starts the application */
    public static void main(String[] args) {
        CaesarCipherDecoder caesarCipherDecoder = new CaesarCipherDecoder();
        caesarCipherDecoder.startDecode();
    }
}
