package encryptdecrypt.algorithm;

import encryptdecrypt.ModeInterface;

public abstract class Algorithm {

    private ModeInterface modeInterface;

    public String process(String data, int n) {
        char[] arr = data.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = modeInterface.process(arr[i], n);
        }
        return new String(arr);
    }

    public void setModeInterface(ModeEnum modeEnum) {
        this.modeInterface = getModeInterface(modeEnum);
    }

    abstract ModeInterface getModeInterface(ModeEnum modeEnum);
}
