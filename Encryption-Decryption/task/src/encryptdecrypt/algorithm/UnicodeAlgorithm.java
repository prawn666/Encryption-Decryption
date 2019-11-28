package encryptdecrypt.algorithm;

import encryptdecrypt.ModeInterface;

public class UnicodeAlgorithm extends Algorithm {
    //97 - 122 65 - 90
    @Override
    ModeInterface getModeInterface(ModeEnum modeEnum) {
        switch (modeEnum) {
            case ENCRYPT:
                return new Encrypt();
            case DECRYPT:
                return new Decrypt();
            default:
                return null;
        }
    }

    private static class Encrypt implements ModeInterface {
        @Override
        public char process(char c, int n) {
            return (char) (c + n);
        }
    }

    private static class Decrypt implements ModeInterface {
        @Override
        public char process(char c, int n) {
            return (char) (c - n);
        }
    }
}
