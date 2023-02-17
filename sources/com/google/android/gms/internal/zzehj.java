package com.google.android.gms.internal;
public final class zzehj {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static int zzngq = 11;
    private static int zzngr = 12;
    private static int zzngs = 16;
    private static int zzngt = 26;
    public static final int[] zzngu = new int[0];
    public static final long[] zzngv = new long[0];
    public static final float[] zzngw = new float[0];
    private static double[] zzngx = new double[0];
    public static final boolean[] zzngy = new boolean[0];
    public static final byte[][] zzngz = new byte[0][];
    public static final byte[] zznha = new byte[0];

    public static final int zzb(zzegx zzegx, int i) {
        int i2 = 1;
        int position = zzegx.getPosition();
        zzegx.zzha(i);
        while (zzegx.zzcby() == i) {
            zzegx.zzha(i);
            i2++;
        }
        zzegx.zzae(position, i);
        return i2;
    }
}
