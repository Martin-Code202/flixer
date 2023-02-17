package org.java_websocket.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.java_websocket.exceptions.InvalidDataException;
public class Charsetfunctions {
    public static CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;

    public static byte[] utf8Bytes(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String stringAscii(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String stringUtf8(ByteBuffer byteBuffer) {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(codingErrorAction);
        newDecoder.onUnmappableCharacter(codingErrorAction);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e) {
            throw new InvalidDataException(1007, e);
        }
    }
}
