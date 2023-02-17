package android.support.v4.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;
public class PathParser {
    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, Math.min(i3, length - i));
        return fArr2;
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int i2 = 1;
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            int nextStart = nextStart(str, i2);
            String trim = str.substring(i, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i = nextStart;
            i2 = nextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (!(pathDataNodeArr[i].mType == pathDataNodeArr2[i].mType && pathDataNodeArr[i].mParams.length == pathDataNodeArr2[i].mParams.length)) {
                return false;
            }
        }
        return true;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    /* access modifiers changed from: package-private */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            int i = 0;
            int i2 = 1;
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            while (i2 < length) {
                extract(str, i2, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i2 < i3) {
                    i++;
                    fArr[i] = Float.parseFloat(str.substring(i2, i3));
                }
                if (extractFloatResult.mEndWithNegOrDot) {
                    i2 = i3;
                } else {
                    i2 = i3 + 1;
                }
            }
            return copyOfRange(fArr, 0, i);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        boolean z = false;
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            z3 = false;
            switch (str.charAt(i2)) {
                case ' ':
                case ',':
                    z = true;
                    break;
                case '-':
                    if (i2 != i && !z3) {
                        z = true;
                        extractFloatResult.mEndWithNegOrDot = true;
                        break;
                    }
                case '.':
                    if (!z2) {
                        z2 = true;
                        break;
                    } else {
                        z = true;
                        extractFloatResult.mEndWithNegOrDot = true;
                        break;
                    }
                case 'E':
                case 'e':
                    z3 = true;
                    break;
            }
            if (z) {
                extractFloatResult.mEndPosition = i2;
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            this.mParams = PathParser.copyOfRange(pathDataNode.mParams, 0, pathDataNode.mParams.length);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            for (int i = 0; i < pathDataNode.mParams.length; i++) {
                this.mParams[i] = (pathDataNode.mParams[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
            }
        }

        private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i = 2;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    f = f5;
                    f2 = f6;
                    f3 = f5;
                    f4 = f6;
                    path.moveTo(f, f2);
                    break;
            }
            for (int i2 = 0; i2 < fArr2.length; i2 += i) {
                switch (c2) {
                    case 'A':
                        drawArc(path, f, f2, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f = fArr2[i2 + 5];
                        f2 = fArr2[i2 + 6];
                        f3 = f;
                        f4 = f2;
                        break;
                    case 'C':
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        f = fArr2[i2 + 4];
                        f2 = fArr2[i2 + 5];
                        f3 = fArr2[i2 + 2];
                        f4 = fArr2[i2 + 3];
                        break;
                    case 'H':
                        path.lineTo(fArr2[i2 + 0], f2);
                        f = fArr2[i2 + 0];
                        break;
                    case 'L':
                        path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f = fArr2[i2 + 0];
                        f2 = fArr2[i2 + 1];
                        break;
                    case 'M':
                        f = fArr2[i2 + 0];
                        f2 = fArr2[i2 + 1];
                        if (i2 > 0) {
                            path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            break;
                        } else {
                            path.moveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f5 = f;
                            f6 = f2;
                            break;
                        }
                    case 'Q':
                        path.quadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f3 = fArr2[i2 + 0];
                        f4 = fArr2[i2 + 1];
                        f = fArr2[i2 + 2];
                        f2 = fArr2[i2 + 3];
                        break;
                    case 'S':
                        float f7 = f;
                        float f8 = f2;
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f7 = (2.0f * f) - f3;
                            f8 = (2.0f * f2) - f4;
                        }
                        path.cubicTo(f7, f8, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f3 = fArr2[i2 + 0];
                        f4 = fArr2[i2 + 1];
                        f = fArr2[i2 + 2];
                        f2 = fArr2[i2 + 3];
                        break;
                    case 'T':
                        float f9 = f;
                        float f10 = f2;
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f9 = (2.0f * f) - f3;
                            f10 = (2.0f * f2) - f4;
                        }
                        path.quadTo(f9, f10, fArr2[i2 + 0], fArr2[i2 + 1]);
                        f3 = f9;
                        f4 = f10;
                        f = fArr2[i2 + 0];
                        f2 = fArr2[i2 + 1];
                        break;
                    case 'V':
                        path.lineTo(f, fArr2[i2 + 0]);
                        f2 = fArr2[i2 + 0];
                        break;
                    case 'a':
                        drawArc(path, f, f2, fArr2[i2 + 5] + f, fArr2[i2 + 6] + f2, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f += fArr2[i2 + 5];
                        f2 += fArr2[i2 + 6];
                        f3 = f;
                        f4 = f2;
                        break;
                    case 'c':
                        path.rCubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        f3 = f + fArr2[i2 + 2];
                        f4 = f2 + fArr2[i2 + 3];
                        f += fArr2[i2 + 4];
                        f2 += fArr2[i2 + 5];
                        break;
                    case 'h':
                        path.rLineTo(fArr2[i2 + 0], 0.0f);
                        f += fArr2[i2 + 0];
                        break;
                    case 'l':
                        path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        f += fArr2[i2 + 0];
                        f2 += fArr2[i2 + 1];
                        break;
                    case 'm':
                        f += fArr2[i2 + 0];
                        f2 += fArr2[i2 + 1];
                        if (i2 > 0) {
                            path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            break;
                        } else {
                            path.rMoveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f5 = f;
                            f6 = f2;
                            break;
                        }
                    case 'q':
                        path.rQuadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f3 = f + fArr2[i2 + 0];
                        f4 = f2 + fArr2[i2 + 1];
                        f += fArr2[i2 + 2];
                        f2 += fArr2[i2 + 3];
                        break;
                    case 's':
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f11 = f - f3;
                            f12 = f2 - f4;
                        }
                        path.rCubicTo(f11, f12, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        f3 = f + fArr2[i2 + 0];
                        f4 = f2 + fArr2[i2 + 1];
                        f += fArr2[i2 + 2];
                        f2 += fArr2[i2 + 3];
                        break;
                    case 't':
                        float f13 = 0.0f;
                        float f14 = 0.0f;
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f13 = f - f3;
                            f14 = f2 - f4;
                        }
                        path.rQuadTo(f13, f14, fArr2[i2 + 0], fArr2[i2 + 1]);
                        f3 = f + f13;
                        f4 = f2 + f14;
                        f += fArr2[i2 + 0];
                        f2 += fArr2[i2 + 1];
                        break;
                    case 'v':
                        path.rLineTo(0.0f, fArr2[i2 + 0]);
                        f2 += fArr2[i2 + 0];
                        break;
                }
                c = c2;
            }
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f4;
            fArr[4] = f5;
            fArr[5] = f6;
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
            double d4 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
            double d5 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
            double d6 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
            double d7 = d3 - d5;
            double d8 = d4 - d6;
            double d9 = (d3 + d5) / 2.0d;
            double d10 = (d4 + d6) / 2.0d;
            double d11 = (d7 * d7) + (d8 * d8);
            if (d11 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d12 = (1.0d / d11) - 0.25d;
            if (d12 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d11);
                float sqrt = (float) (Math.sqrt(d11) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d12);
            double d13 = sqrt2 * d7;
            double d14 = sqrt2 * d8;
            if (z == z2) {
                d2 = d9 - d14;
                d = d10 + d13;
            } else {
                d2 = d9 + d14;
                d = d10 - d13;
            }
            double atan2 = Math.atan2(d4 - d, d3 - d2);
            double atan22 = Math.atan2(d6 - d, d5 - d2) - atan2;
            if (z2 != (atan22 >= 0.0d)) {
                if (atan22 > 0.0d) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d15 = d2 * ((double) f5);
            double d16 = d * ((double) f6);
            arcToBezier(path, (d15 * cos) - (d16 * sin), (d15 * sin) + (d16 * cos), (double) f5, (double) f6, (double) f, (double) f2, radians, atan2, atan22);
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
            double d10 = d8;
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d10);
            double sin2 = Math.sin(d10);
            double d11 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
            double d12 = ((-d3) * sin * sin2) + (d4 * cos * cos2);
            double d13 = d9 / ((double) ceil);
            for (int i = 0; i < ceil; i++) {
                double d14 = d10 + d13;
                double sin3 = Math.sin(d14);
                double cos3 = Math.cos(d14);
                double d15 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * sin3);
                double d16 = (d3 * sin * cos3) + d2 + (d4 * cos * sin3);
                double d17 = (((-d3) * cos) * sin3) - ((d4 * sin) * cos3);
                double d18 = ((-d3) * sin * sin3) + (d4 * cos * cos3);
                double tan = Math.tan((d14 - d10) / 2.0d);
                double sin4 = (Math.sin(d14 - d10) * (Math.sqrt(((3.0d * tan) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d5 + (sin4 * d11)), (float) (d6 + (sin4 * d12)), (float) (d15 - (sin4 * d17)), (float) (d16 - (sin4 * d18)), (float) d15, (float) d16);
                d10 = d14;
                d5 = d15;
                d6 = d16;
                d11 = d17;
                d12 = d18;
            }
        }
    }
}
