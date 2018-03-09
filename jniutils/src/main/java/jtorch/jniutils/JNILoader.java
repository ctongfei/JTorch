package jtorch.jniutils;

import java.io.*;
import java.net.*;
import java.nio.file.*;

/**
 * Utility to load a binary library file inside a jar's resource directory.
 * @author Tongfei Chen
 */
public class JNILoader {

    static String JNILIBS = "jnilibs";
    static String osName = System.getProperty("os.name");
    static String tmpDir = System.getProperty("java.io.tmpdir");

    public static URL getLibraryUrl(String libraryName) throws UnsupportedOperationException {
        URL url = null;
        if (osName.startsWith("Windows"))
            url = JNILoader.class.getResource("/" + libraryName + ".dll");
        else if (osName.startsWith("Mac")) {
            url = JNILoader.class.getResource("/lib" + libraryName + ".dylib");
            if (url == null)
                url = JNILoader.class.getResource("/lib" + libraryName + ".so");
            if (url == null)
                url = JNILoader.class.getResource("/lib" + libraryName + ".bundle");
        }
        else if (osName.startsWith("Linux"))
            url = JNILoader.class.getResource("/lib" + libraryName + ".so");

        if (url == null)
            throw new UnsupportedOperationException("Library " + libraryName + " not found.");
        else return url;
    }


    static File createTempDir() {
        File f = new File(tmpDir + "/" + JNILIBS);
        f.mkdir();
        return f;
    }

    public static void loadLibraryFromJar(String libraryName) throws IOException {

        File tempDir = createTempDir();
        URL url = getLibraryUrl(libraryName);
        String fileName = new File(url.getPath()).getName();
        File lib = new File(tempDir, fileName);
        try (InputStream is = getLibraryUrl(libraryName).openStream()) {
            Files.copy(is, lib.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            throw e;
        }

        System.load(lib.getAbsolutePath()); // JVM requires absolute path

    }

}
