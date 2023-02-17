package com.netflix.mediaclient.service.webclient.volley;

import com.android.volley.VolleyError;
public class ParseException extends VolleyError {
    public ParseException() {
    }

    public ParseException(String str) {
        super(str);
    }

    public ParseException(Throwable th) {
        super(th);
    }
}
