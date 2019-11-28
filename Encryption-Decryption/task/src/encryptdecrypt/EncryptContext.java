package encryptdecrypt;

import encryptdecrypt.algorithm.Algorithm;
import encryptdecrypt.algorithm.AlgorithmEnum;
import encryptdecrypt.algorithm.AlgorithmFactory;
import encryptdecrypt.algorithm.ModeEnum;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptContext {

    private String data = "";
    private ModeEnum modeEnum = ModeEnum.ENCRYPT;
    private AlgorithmFactory algorithmFactory = new AlgorithmFactory();
    private AlgorithmEnum algorithmEnum = AlgorithmEnum.SHIFT;
    private int n;
    private PrintStream out = System.out;

    public void setData(String data) {
        if (this.data.equals("")) {
            this.data = data;
        }
    }

    public void setMode(String mode) {
        if (mode.equals("dec")) {
            this.modeEnum = ModeEnum.DECRYPT;
        } else if (mode.equals("enc")) {
            this.modeEnum = ModeEnum.ENCRYPT;
        }
    }

    public void setAlgorithm(String algorithm) {
        if (algorithm.equals("unicode")) {
            algorithmEnum = AlgorithmEnum.UNICODE;
        } else if (algorithm.equals("shift")) {
            algorithmEnum = AlgorithmEnum.SHIFT;
        }
    }


    public void setN(int n) {
        this.n = n;
    }

    public void setInput(String path) {
        try {
            data = Files.readAllLines(Paths.get(path)).stream()
                    .reduce(String::concat)
                    .orElse("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOutput(String path) {
        try {
            out = new PrintStream(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process() {
        Algorithm algorithm = algorithmFactory.getAlgorithm(modeEnum, algorithmEnum);
        String res = algorithm.process(data, n);
        out.print(res);
        out.close();
    }
}
