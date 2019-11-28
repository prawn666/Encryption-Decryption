package encryptdecrypt.algorithm;

public class AlgorithmFactory {

    public Algorithm getAlgorithm(ModeEnum modeEnum, AlgorithmEnum algorithmEnum) {
        Algorithm algorithm;
        if (algorithmEnum.equals(AlgorithmEnum.SHIFT)) {
            algorithm = new ShiftAlgorithm();
        } else if (algorithmEnum.equals(AlgorithmEnum.UNICODE)) {
            algorithm = new UnicodeAlgorithm();
        } else {
            throw new RuntimeException("no alg");
        }
        algorithm.setModeInterface(modeEnum);
        return algorithm;
    }
}
