package com.ibm.icu.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
public abstract class URLHandler {
    private static final boolean DEBUG = ICUDebug.enabled("URLHandler");
    private static final Map<String, Method> handlers;

    public interface URLVisitor {
        void visit(String str);
    }

    public abstract void guide(URLVisitor uRLVisitor, boolean z, boolean z2);

    static {
        HashMap hashMap = null;
        BufferedReader bufferedReader = null;
        try {
            InputStream resourceAsStream = ClassLoaderUtil.getClassLoader(URLHandler.class).getResourceAsStream("urlhandler.props");
            if (resourceAsStream != null) {
                Class<?>[] clsArr = {URL.class};
                bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
                String readLine = bufferedReader.readLine();
                while (true) {
                    if (readLine == null) {
                        break;
                    }
                    String trim = readLine.trim();
                    if (trim.length() != 0) {
                        if (trim.charAt(0) != '#') {
                            int indexOf = trim.indexOf(61);
                            if (indexOf != -1) {
                                String trim2 = trim.substring(0, indexOf).trim();
                                try {
                                    Method declaredMethod = Class.forName(trim.substring(indexOf + 1).trim()).getDeclaredMethod("get", clsArr);
                                    if (hashMap == null) {
                                        hashMap = new HashMap();
                                    }
                                    hashMap.put(trim2, declaredMethod);
                                } catch (ClassNotFoundException e) {
                                    if (DEBUG) {
                                        System.err.println(e);
                                    }
                                } catch (NoSuchMethodException e2) {
                                    if (DEBUG) {
                                        System.err.println(e2);
                                    }
                                } catch (SecurityException e3) {
                                    if (DEBUG) {
                                        System.err.println(e3);
                                    }
                                }
                            } else if (DEBUG) {
                                System.err.println("bad urlhandler line: '" + trim + "'");
                            }
                        }
                    }
                    readLine = bufferedReader.readLine();
                }
                bufferedReader.close();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        handlers = hashMap;
    }

    public static URLHandler get(URL url) {
        Method method;
        if (url == null) {
            return null;
        }
        String protocol = url.getProtocol();
        if (!(handlers == null || (method = handlers.get(protocol)) == null)) {
            try {
                URLHandler uRLHandler = (URLHandler) method.invoke(null, url);
                if (uRLHandler != null) {
                    return uRLHandler;
                }
            } catch (IllegalAccessException e) {
                if (DEBUG) {
                    System.err.println(e);
                }
            } catch (IllegalArgumentException e2) {
                if (DEBUG) {
                    System.err.println(e2);
                }
            } catch (InvocationTargetException e3) {
                if (DEBUG) {
                    System.err.println(e3);
                }
            }
        }
        return getDefault(url);
    }

    protected static URLHandler getDefault(URL url) {
        String protocol = url.getProtocol();
        try {
            if (protocol.equals("file")) {
                return new FileURLHandler(url);
            }
            if (protocol.equals("jar") || protocol.equals("wsjar")) {
                return new JarURLHandler(url);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class FileURLHandler extends URLHandler {
        File file;

        FileURLHandler(URL url) {
            try {
                this.file = new File(url.toURI());
            } catch (URISyntaxException e) {
            }
            if (this.file == null || !this.file.exists()) {
                if (URLHandler.DEBUG) {
                    System.err.println("file does not exist - " + url.toString());
                }
                throw new IllegalArgumentException();
            }
        }

        @Override // com.ibm.icu.impl.URLHandler
        public void guide(URLVisitor uRLVisitor, boolean z, boolean z2) {
            if (this.file.isDirectory()) {
                process(uRLVisitor, z, z2, "/", this.file.listFiles());
            } else {
                uRLVisitor.visit(this.file.getName());
            }
        }

        private void process(URLVisitor uRLVisitor, boolean z, boolean z2, String str, File[] fileArr) {
            if (fileArr != null) {
                for (File file2 : fileArr) {
                    if (!file2.isDirectory()) {
                        uRLVisitor.visit(z2 ? file2.getName() : str + file2.getName());
                    } else if (z) {
                        process(uRLVisitor, z, z2, str + file2.getName() + '/', file2.listFiles());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class JarURLHandler extends URLHandler {
        JarFile jarFile;
        String prefix;

        JarURLHandler(URL url) {
            String url2;
            int indexOf;
            try {
                this.prefix = url.getPath();
                int lastIndexOf = this.prefix.lastIndexOf("!/");
                if (lastIndexOf >= 0) {
                    this.prefix = this.prefix.substring(lastIndexOf + 2);
                }
                if (!url.getProtocol().equals("jar") && (indexOf = (url2 = url.toString()).indexOf(":")) != -1) {
                    url = new URL("jar" + url2.substring(indexOf));
                }
                this.jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
            } catch (Exception e) {
                if (URLHandler.DEBUG) {
                    System.err.println("icurb jar error: " + e);
                }
                throw new IllegalArgumentException("jar error: " + e.getMessage());
            }
        }

        @Override // com.ibm.icu.impl.URLHandler
        public void guide(URLVisitor uRLVisitor, boolean z, boolean z2) {
            try {
                Enumeration<JarEntry> entries = this.jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory()) {
                        String name = nextElement.getName();
                        if (name.startsWith(this.prefix)) {
                            String substring = name.substring(this.prefix.length());
                            int lastIndexOf = substring.lastIndexOf(47);
                            if (lastIndexOf <= 0 || z) {
                                if (z2 && lastIndexOf != -1) {
                                    substring = substring.substring(lastIndexOf + 1);
                                }
                                uRLVisitor.visit(substring);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                if (URLHandler.DEBUG) {
                    System.err.println("icurb jar error: " + e);
                }
            }
        }
    }

    public void guide(URLVisitor uRLVisitor, boolean z) {
        guide(uRLVisitor, z, true);
    }
}
