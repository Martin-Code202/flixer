package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
public final class Streams {
    public static JsonElement parse(JsonReader jsonReader) {
        boolean z = true;
        try {
            jsonReader.peek();
            z = false;
            return TypeAdapters.JSON_ELEMENT.read(jsonReader);
        } catch (EOFException e) {
            if (z) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(e);
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        AppendableWriter(Appendable appendable2) {
            this.appendable = appendable2;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            this.currentWrite.chars = cArr;
            this.appendable.append(this.currentWrite, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) {
            this.appendable.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        static class CurrentWrite implements CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.chars[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.chars, i, i2 - i);
            }
        }
    }
}
