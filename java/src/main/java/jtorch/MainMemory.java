package jtorch;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tongfei Chen
 */
public class MainMemory {

    static private HashMap<Long, MainMemoryNativeObject> objects;
    static private AtomicInteger totalSize;

    static public void register(MainMemoryNativeObject o) {
        objects.put(o.cPtr(), o);
    }

}
