package encryptdecrypt.algorithm;

import encryptdecrypt.ModeInterface;

public class ShiftAlgorithm extends Algorithm {

    //97 - 122 65 - 90
    private static RangeOperations lower = new RangeOperations(97, 122);
    private static RangeOperations upper = new RangeOperations(65, 90);

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
            if (c >= 97 && c <= 122) {
                return (char) lower.plus(c, n);
            } else if (c >= 65 && c <= 90) {
                return (char) upper.plus(c, n);
            }
            return c;
        }
    }

    private static class Decrypt implements ModeInterface {
        @Override
        public char process(char c, int n) {
            if (c >= 97 && c <= 122) {
                return (char) lower.minus(c, n);
            } else if (c >= 65 && c <= 90) {
                return (char) upper.minus(c, n);
            }
            return c;
        }
    }

    private static class RangeOperations{
        private int start, end, range;

        public RangeOperations(int start, int end) {
            this.start = start;
            this.end = end;
            range = end - start + 1;
        }

        public int plus(int from, int number) {
            int tmp = number % range;
            if (from + tmp > end) {
                return start - 1 + (from + tmp - end);
            }
            return from + tmp;
        }

        public int minus (int from, int number) {
            int tmp = number % range;
            if (from - tmp < start) {
                return end + 1 - (start - from + tmp);
            }
            return from - tmp;
        }
    }
}
