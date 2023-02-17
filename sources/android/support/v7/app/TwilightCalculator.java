package android.support.v7.app;
/* access modifiers changed from: package-private */
public class TwilightCalculator {
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
    }

    static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j, double d, double d2) {
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = 6.24006f + (0.01720197f * f);
        double sin = 1.796593063d + ((double) f2) + (Math.sin((double) f2) * 0.03341960161924362d) + (Math.sin((double) (2.0f * f2)) * 3.4906598739326E-4d) + (Math.sin((double) (3.0f * f2)) * 5.236000106378924E-6d) + 3.141592653589793d;
        double d3 = (-d2) / 360.0d;
        double round = ((double) (9.0E-4f + ((float) Math.round(((double) (f - 9.0E-4f)) - d3)))) + d3 + (Math.sin((double) f2) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d4 = d * 0.01745329238474369d;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(asin))) / (Math.cos(d4) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.state = 1;
            this.sunset = -1;
            this.sunrise = -1;
        } else if (sin2 <= -1.0d) {
            this.state = 0;
            this.sunset = -1;
            this.sunrise = -1;
        } else {
            float acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.sunset = Math.round((((double) acos) + round) * 8.64E7d) + 946728000000L;
            this.sunrise = Math.round((round - ((double) acos)) * 8.64E7d) + 946728000000L;
            if (this.sunrise >= j || this.sunset <= j) {
                this.state = 1;
            } else {
                this.state = 0;
            }
        }
    }
}
