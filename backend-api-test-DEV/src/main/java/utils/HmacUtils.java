package utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@UtilityClass
public class HmacUtils {
    public String calcHmacSha256(byte[] secretKey, byte[] message) {
        byte[] hmacSha256;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to calculate hmac-sha256", e);
        }

        return Hex.encodeHexString(hmacSha256);
    }

}
