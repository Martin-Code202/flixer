package com.ibm.icu.impl;
public class CalendarAstronomer {
    public static final SolarLongitude AUTUMN_EQUINOX = new SolarLongitude(3.141592653589793d);
    public static final MoonAge FIRST_QUARTER = new MoonAge(1.5707963267948966d);
    public static final MoonAge FULL_MOON = new MoonAge(3.141592653589793d);
    public static final MoonAge LAST_QUARTER = new MoonAge(4.71238898038469d);
    public static final MoonAge NEW_MOON = new MoonAge(0.0d);
    public static final SolarLongitude SUMMER_SOLSTICE = new SolarLongitude(1.5707963267948966d);
    public static final SolarLongitude VERNAL_EQUINOX = new SolarLongitude(0.0d);
    public static final SolarLongitude WINTER_SOLSTICE = new SolarLongitude(4.71238898038469d);
    private transient double eclipObliquity;
    private long fGmtOffset;
    private double fLatitude;
    private double fLongitude;
    private transient double julianCentury;
    private transient double julianDay;
    private transient double meanAnomalySun;
    private transient double moonEclipLong;
    private transient double moonLongitude;
    private transient Equatorial moonPosition;
    private transient double siderealT0;
    private transient double siderealTime;
    private transient double sunLongitude;
    private long time;

    /* access modifiers changed from: package-private */
    public interface AngleFunc {
        double eval();
    }

    public CalendarAstronomer() {
        this(System.currentTimeMillis());
    }

    public CalendarAstronomer(long j) {
        this.fLongitude = 0.0d;
        this.fLatitude = 0.0d;
        this.fGmtOffset = 0;
        this.julianDay = Double.MIN_VALUE;
        this.julianCentury = Double.MIN_VALUE;
        this.sunLongitude = Double.MIN_VALUE;
        this.meanAnomalySun = Double.MIN_VALUE;
        this.moonLongitude = Double.MIN_VALUE;
        this.moonEclipLong = Double.MIN_VALUE;
        this.eclipObliquity = Double.MIN_VALUE;
        this.siderealT0 = Double.MIN_VALUE;
        this.siderealTime = Double.MIN_VALUE;
        this.moonPosition = null;
        this.time = j;
    }

    public void setTime(long j) {
        this.time = j;
        clearCache();
    }

    public double getJulianDay() {
        if (this.julianDay == Double.MIN_VALUE) {
            this.julianDay = ((double) (this.time - -210866760000000L)) / 8.64E7d;
        }
        return this.julianDay;
    }

    public final Equatorial eclipticToEquatorial(double d, double d2) {
        double eclipticObliquity = eclipticObliquity();
        double sin = Math.sin(eclipticObliquity);
        double cos = Math.cos(eclipticObliquity);
        double sin2 = Math.sin(d);
        return new Equatorial(Math.atan2((sin2 * cos) - (Math.tan(d2) * sin), Math.cos(d)), Math.asin((Math.sin(d2) * cos) + (Math.cos(d2) * sin * sin2)));
    }

    public double getSunLongitude() {
        if (this.sunLongitude == Double.MIN_VALUE) {
            double[] sunLongitude2 = getSunLongitude(getJulianDay());
            this.sunLongitude = sunLongitude2[0];
            this.meanAnomalySun = sunLongitude2[1];
        }
        return this.sunLongitude;
    }

    /* access modifiers changed from: package-private */
    public double[] getSunLongitude(double d) {
        double norm2PI = norm2PI((4.87650757829735d + norm2PI(0.017202791632524146d * (d - 2447891.5d))) - 4.935239984568769d);
        return new double[]{norm2PI(trueAnomaly(norm2PI, 0.016713d) + 4.935239984568769d), norm2PI};
    }

    public static class SolarLongitude {
        double value;

        SolarLongitude(double d) {
            this.value = d;
        }
    }

    public long getSunTime(double d, boolean z) {
        return timeOfAngle(new AngleFunc() { // from class: com.ibm.icu.impl.CalendarAstronomer.1
            @Override // com.ibm.icu.impl.CalendarAstronomer.AngleFunc
            public double eval() {
                return CalendarAstronomer.this.getSunLongitude();
            }
        }, d, 365.242191d, 60000, z);
    }

    public long getSunTime(SolarLongitude solarLongitude, boolean z) {
        return getSunTime(solarLongitude.value, z);
    }

    public Equatorial getMoonPosition() {
        if (this.moonPosition == null) {
            double sunLongitude2 = getSunLongitude();
            double julianDay2 = getJulianDay() - 2447891.5d;
            double norm2PI = norm2PI((0.22997150421858628d * julianDay2) + 5.556284436750021d);
            double norm2PI2 = norm2PI((norm2PI - (0.001944368345221015d * julianDay2)) - 0.6342598060246725d);
            double sin = 0.022233749341155764d * Math.sin(((norm2PI - sunLongitude2) * 2.0d) - norm2PI2);
            double sin2 = 0.003242821750205464d * Math.sin(this.meanAnomalySun);
            double sin3 = norm2PI2 + ((sin - sin2) - (0.00645771823237902d * Math.sin(this.meanAnomalySun)));
            this.moonLongitude = (((norm2PI + sin) + (0.10975677534091541d * Math.sin(sin3))) - sin2) + (0.0037350045992678655d * Math.sin(2.0d * sin3));
            this.moonLongitude += 0.011489502465878671d * Math.sin((this.moonLongitude - sunLongitude2) * 2.0d);
            double norm2PI3 = norm2PI(5.559050068029439d - (9.242199067718253E-4d * julianDay2)) - (Math.sin(this.meanAnomalySun) * 0.0027925268031909274d);
            double sin4 = Math.sin(this.moonLongitude - norm2PI3);
            this.moonEclipLong = Math.atan2(Math.cos(0.08980357792017056d) * sin4, Math.cos(this.moonLongitude - norm2PI3)) + norm2PI3;
            this.moonPosition = eclipticToEquatorial(this.moonEclipLong, Math.asin(Math.sin(0.08980357792017056d) * sin4));
        }
        return this.moonPosition;
    }

    public double getMoonAge() {
        getMoonPosition();
        return norm2PI(this.moonEclipLong - this.sunLongitude);
    }

    public static class MoonAge {
        double value;

        MoonAge(double d) {
            this.value = d;
        }
    }

    public long getMoonTime(double d, boolean z) {
        return timeOfAngle(new AngleFunc() { // from class: com.ibm.icu.impl.CalendarAstronomer.3
            @Override // com.ibm.icu.impl.CalendarAstronomer.AngleFunc
            public double eval() {
                return CalendarAstronomer.this.getMoonAge();
            }
        }, d, 29.530588853d, 60000, z);
    }

    public long getMoonTime(MoonAge moonAge, boolean z) {
        return getMoonTime(moonAge.value, z);
    }

    private long timeOfAngle(AngleFunc angleFunc, double d, double d2, long j, boolean z) {
        double eval = angleFunc.eval();
        double norm2PI = (((z ? 0.0d : -6.283185307179586d) + norm2PI(d - eval)) * (8.64E7d * d2)) / 6.283185307179586d;
        double d3 = norm2PI;
        long j2 = this.time;
        setTime(this.time + ((long) norm2PI));
        do {
            double eval2 = angleFunc.eval();
            norm2PI = normPI(d - eval2) * Math.abs(norm2PI / normPI(eval2 - eval));
            if (Math.abs(norm2PI) > Math.abs(d3)) {
                long j3 = (long) ((8.64E7d * d2) / 8.0d);
                setTime((z ? j3 : -j3) + j2);
                return timeOfAngle(angleFunc, d, d2, j, z);
            }
            d3 = norm2PI;
            eval = eval2;
            setTime(this.time + ((long) norm2PI));
        } while (Math.abs(norm2PI) > ((double) j));
        return this.time;
    }

    private static final double normalize(double d, double d2) {
        return d - (Math.floor(d / d2) * d2);
    }

    private static final double norm2PI(double d) {
        return normalize(d, 6.283185307179586d);
    }

    private static final double normPI(double d) {
        return normalize(3.141592653589793d + d, 6.283185307179586d) - 3.141592653589793d;
    }

    private double trueAnomaly(double d, double d2) {
        double sin;
        double d3 = d;
        do {
            sin = (d3 - (Math.sin(d3) * d2)) - d;
            d3 -= sin / (1.0d - (Math.cos(d3) * d2));
        } while (Math.abs(sin) > 1.0E-5d);
        return Math.atan(Math.tan(d3 / 2.0d) * Math.sqrt((1.0d + d2) / (1.0d - d2))) * 2.0d;
    }

    private double eclipticObliquity() {
        if (this.eclipObliquity == Double.MIN_VALUE) {
            double julianDay2 = (getJulianDay() - 2451545.0d) / 36525.0d;
            this.eclipObliquity = ((23.439292d - (0.013004166666666666d * julianDay2)) - ((1.6666666666666665E-7d * julianDay2) * julianDay2)) + (5.027777777777778E-7d * julianDay2 * julianDay2 * julianDay2);
            this.eclipObliquity *= 0.017453292519943295d;
        }
        return this.eclipObliquity;
    }

    private void clearCache() {
        this.julianDay = Double.MIN_VALUE;
        this.julianCentury = Double.MIN_VALUE;
        this.sunLongitude = Double.MIN_VALUE;
        this.meanAnomalySun = Double.MIN_VALUE;
        this.moonLongitude = Double.MIN_VALUE;
        this.moonEclipLong = Double.MIN_VALUE;
        this.eclipObliquity = Double.MIN_VALUE;
        this.siderealTime = Double.MIN_VALUE;
        this.siderealT0 = Double.MIN_VALUE;
        this.moonPosition = null;
    }

    public static final class Equatorial {
        public final double ascension;
        public final double declination;

        public Equatorial(double d, double d2) {
            this.ascension = d;
            this.declination = d2;
        }

        public String toString() {
            return Double.toString(this.ascension * 57.29577951308232d) + "," + (this.declination * 57.29577951308232d);
        }
    }
}
