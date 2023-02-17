package org.linphone.core;

import java.util.Vector;
public interface LinphoneCallLog {
    int getCallDuration();

    String getCallId();

    CallDirection getDirection();

    LinphoneAddress getFrom();

    String getStartDate();

    CallStatus getStatus();

    long getTimestamp();

    LinphoneAddress getTo();

    boolean wasConference();

    public static class CallStatus {
        public static final CallStatus Aborted = new CallStatus(1, "Aborted");
        public static final CallStatus AcceptedElsewhere = new CallStatus(5, "Accepted Elsewhere");
        public static final CallStatus Declined = new CallStatus(3, "Declined");
        public static final CallStatus DeclinedElsewhere = new CallStatus(6, "Declined Elsewhere");
        public static final CallStatus EarlyAborted = new CallStatus(4, "Early Aborted");
        public static final CallStatus Missed = new CallStatus(2, "Missed");
        public static final CallStatus Success = new CallStatus(0, "Success");
        private static Vector<CallStatus> values = new Vector<>();
        private final String mStringValue;
        private final int mValue;

        private CallStatus(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static CallStatus fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                CallStatus elementAt = values.elementAt(i2);
                if (elementAt.mValue == i) {
                    return elementAt;
                }
            }
            throw new RuntimeException("CallStatus not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
