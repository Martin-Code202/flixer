package org.linphone.core;

import java.util.Vector;
public interface LinphoneXmlRpcRequest {

    public interface LinphoneXmlRpcRequestListener {
        void onXmlRpcRequestResponse(LinphoneXmlRpcRequest linphoneXmlRpcRequest);
    }

    void addIntArg(int i);

    void addStringArg(String str);

    String getContent();

    int getIntResponse();

    Status getStatus();

    String getStringResponse();

    void setListener(LinphoneXmlRpcRequestListener linphoneXmlRpcRequestListener);

    public static class ArgType {
        public static final ArgType Int = new ArgType(1, "Int");
        public static final ArgType None = new ArgType(0, "None");
        public static final ArgType String = new ArgType(2, "String");
        private static Vector<ArgType> values = new Vector<>();
        private final String mStringValue;
        private final int mValue;

        public final int value() {
            return this.mValue;
        }

        private ArgType(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static ArgType fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                ArgType elementAt = values.elementAt(i2);
                if (elementAt.mValue == i) {
                    return elementAt;
                }
            }
            throw new RuntimeException("ArgType not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public static class Status {
        public static final Status Failed = new Status(2, "Failed");
        public static final Status Ok = new Status(1, "Ok");
        public static final Status Pending = new Status(0, "Pending");
        private static Vector<Status> values = new Vector<>();
        private final String mStringValue;
        private final int mValue;

        public final int value() {
            return this.mValue;
        }

        private Status(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static Status fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                Status elementAt = values.elementAt(i2);
                if (elementAt.mValue == i) {
                    return elementAt;
                }
            }
            throw new RuntimeException("Status not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
