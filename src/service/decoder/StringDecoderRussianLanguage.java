package service.decoder;

/** Decode String, shifts all letters of the Russian alphabet to the right */
public class StringDecoderRussianLanguage implements Decoder {
    @Override
    public String shiftRightByNumberOfCharacter(String inputData, int shiftValue) {
        StringBuilder stringBuilderInputData = new StringBuilder(inputData);
        char bufferCharacter;

        for (int i = 0; i < stringBuilderInputData.length(); i++) {
            bufferCharacter = stringBuilderInputData.charAt(i);
            if (Character.isLetter(bufferCharacter)) {
                bufferCharacter = ShiftRightRussianLanguage
                        .shiftRightCharacter(bufferCharacter, shiftValue);
                stringBuilderInputData.setCharAt(i, bufferCharacter);
            }
        }
        return stringBuilderInputData.toString();
    }
}