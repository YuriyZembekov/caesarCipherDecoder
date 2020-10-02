package service.decoder;

class ShiftRightRussianLanguage {
    final static int COUNT_LETTER_IN_ALPHABET = 33;

    // Сдвигает входной символ на shiftValue позиций вправо
    // если это русская буква
    // иначе возвращает входной символ
    static char shiftRightCharacter(char inputCharacter, int shiftValue) {
        if ((inputCharacter >= 1040 && inputCharacter <= 1103 // проверка на русскую букву
                || inputCharacter == 1025 || inputCharacter == 1105)) {
            int numberLetterInAlphabet = formatToNumberAlphabet(inputCharacter);
            int shiftRightLetter = shiftRightLetterInAlphabet(numberLetterInAlphabet, shiftValue);
            return formatToCharacter(shiftRightLetter);
        } else {
            return inputCharacter;
        }
    }

    // Преобразует символ в номер буквы русского алфавита
    // 1-33 для верхнего регистра, 34-66 для нижнего регистра
    private static int formatToNumberAlphabet(char inputChar) {
        if (inputChar >= 'А' && inputChar <= 'Е') {
            return inputChar - 1039;
        } else if (inputChar >= 'Ж' && inputChar <= 'е') {
            return inputChar - 1038;
        } else if (inputChar == 'Ё') {
            return inputChar - 1018;
        } else if (inputChar == 'ё') {
            return inputChar - 1065;
        } else {
            return inputChar - 1037;
        }
    }

    // Сдвигает вправо букву под номером numberInAlphabet
    // на shiftValue позиций
    private static int shiftRightLetterInAlphabet(int numberInAlphabet, int shiftValue) {
        if (numberInAlphabet <= COUNT_LETTER_IN_ALPHABET) {
            numberInAlphabet += shiftValue;
            if (numberInAlphabet > COUNT_LETTER_IN_ALPHABET) {
                numberInAlphabet -= COUNT_LETTER_IN_ALPHABET;
            }
        } else {
            numberInAlphabet += shiftValue;
            if (numberInAlphabet > COUNT_LETTER_IN_ALPHABET * 2) {
                numberInAlphabet -= COUNT_LETTER_IN_ALPHABET;
            }
        }
        return numberInAlphabet;
    }

    // Преобразует номер буквы русского алфавита в символ UNICODE
    private static char formatToCharacter(int numberInAlphabet) {
        if (numberInAlphabet <= 6) {
            numberInAlphabet += 1039;
        } else if (numberInAlphabet >= 8 && numberInAlphabet <= 39) {
            numberInAlphabet += 1038;
        } else if (numberInAlphabet == 7) {
            numberInAlphabet += 1018;
        } else if (numberInAlphabet == 40) {
            numberInAlphabet += 1065;
        } else {
            numberInAlphabet += 1037;
        }
        return (char) (numberInAlphabet);
    }
}
