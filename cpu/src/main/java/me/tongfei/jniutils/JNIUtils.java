package me.tongfei.jniutils;

import java.io.*;
import java.net.*;

/**
 * Utility to load a binary library file inside a jar's resource directory.
 * @author Tongfei Chen
 */
public class JNIUtils {
    
    static String JNILIBS = "jnilibs";
    static String osName = System.getProperty("os.name");
    static String tmpDir = System.getProperty("java.io.tmpdir");

    public static URL getLibraryUrl(String libraryName) throws IOException {
        URL url = null;
        if (osName.startsWith("Windows"))
            url = JNIUtils.class.getResource(libraryName + ".dll");
        else if (osName.startsWith("Mac")) {
            url = JNIUtils.class.getResource("lib" + libraryName + ".dylib");
            if (url == null)
                url = JNIUtils.class.getResource("lib" + libraryName + ".so");
            if (url == null)
                url = JNIUtils.class.getResource("lib" + libraryName + ".bundle");
        }
        else if (osName.startsWith("Linux"))
            url = JNIUtils.class.getResource("lib" + libraryName + ".so");

        if (url == null)
            throw new UnsupportedOperationException("Library" + libraryName + "not found.");
        else return url;
    }
    
    
    static File createTempDir(String dir) throws IOException {
        File f = new File(tmpDir + "/" + JNILIBS);
        f.mkdir();
        return f;
    }

    public static void loadLibraryFromJar(String libraryName) throws IOException {

        InputStream is = getLibraryUrl(libraryName).openStream();
        
    }

}
