package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        boolean dataFlag = false;
        StringBuilder data = new StringBuilder();

        EncryptContext encryptContext = new EncryptContext();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-alg":
                    encryptContext.setAlgorithm(args[++i]);
                    break;
                case "-mode":
                    encryptContext.setMode(args[++i]);
                    break;
                case "-key":
                    encryptContext.setN(Integer.parseInt(args[++i]));
                    break;
                case "-data":
                    dataFlag = true;
                    data.append(args[++i]);
                    break;
                case "-in":
                    if (!dataFlag) {
                        encryptContext.setInput(args[++i]);
                    }
                    break;
                case "-out":
                    encryptContext.setOutput(args[++i]);
                    break;
                default:
                    data.append(args[i]);
                    break;
            }
        }
        encryptContext.setData(data.toString());
        encryptContext.process();
    }

}
