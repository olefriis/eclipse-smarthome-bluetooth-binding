package org.xxtea;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class XXTEATest {
    @Test
    public void decryptsName() throws Exception {
        byte[] encryptedBytes = toBytes("ec", "09", "4d", "35", "ea", "c9", "7e", "73", "c6", "19", "28", "4d", "77", "7d", "a8", "cb");
        byte[] key = toBytes("9D", "AC", "DD", "6F", "92", "52", "7A", "AA", "77", "99", "71", "F5", "A4", "7F", "3F", "1C");
        byte[] decodedBytes = XXTEA.decryptEco2String(encryptedBytes, key);
        String decodedString = new String(decodedBytes, Charset.forName("utf-8"));
        Assert.assertEquals("Test", decodedString);
    }

    private byte[] toBytes(String... bytesAsHex) {
        List<Byte> bytesAsList = Arrays.asList(bytesAsHex).stream().map(s -> (byte) Integer.parseInt(s, 16)).collect(Collectors.toList());
        return ArrayUtils.toPrimitive(bytesAsList.<Byte>toArray(new Byte[bytesAsList.size()]));
    }

}
