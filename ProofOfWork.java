import com.google.common.hash.Hashing;
import org.apache.commons.lang3.time.StopWatch;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class ProofOfWork {


public static String proofOfWork (String previousTx, String currentTx, String difficult) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    int nounce = 0;
    while (true) {
        String originalString = previousTx+currentTx+nounce;
        String sha256hex = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();

        if(sha256hex.startsWith(difficult)) {
            stopWatch.stop();
            System.out.println("Difficulty level: "+difficult +"\nNounce: "+nounce +"\nElapsed time: "+stopWatch.getTime()  +" milli seconds\nHashedString: "+sha256hex);
            System.out.println("----------------------------------------------------");
            return sha256hex;
        }
        nounce++;
    }
}


    public static void main(String[] args) {
         proofOfWork("previousTx", "currentTx", "0");
         proofOfWork("previousTx", "currentTx", "0000");
    }
}
