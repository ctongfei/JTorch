package jtorch;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A memory manager used to manage off-JVM-heap memory so
 * that they are automatically reclaimed by the garbage collector.
 * @author Tongfei Chen
 */
public abstract class MemoryManager<O extends NativeObject> {

    private long quota = 4294967296L;
    private boolean debugMode = false;

    // WeakHashMap so that references to keys do not stop the GC from reclaiming them
    private Map<O, Long> objects = Collections.synchronizedMap(new WeakHashMap<>());
    private AtomicLong totalSize = new AtomicLong();

    synchronized public void setQuota(long newQuota) {
        quota = newQuota;
    }

    synchronized public void setDebugMode(boolean newDebugMode) {
        debugMode = newDebugMode;
    }

    synchronized public void register(O o, long size) {
        objects.put(o, o.cPtr());
        long newTotalSize = totalSize.addAndGet(size);
        if (debugMode)
            System.err.println(("[" + getClass().getName() + "] Native object registered. Current memory used: " + totalSize.toString()));

        if (newTotalSize > quota) {
            if (debugMode) {
                System.err.println("[" + getClass().getName() + "] Garbage collection triggered. Current memory used: " + totalSize.toString());
                System.gc();
                System.err.println("[" + getClass().getName() + "] Garbage collection complete. Current memory used: " + totalSize.toString());
            } else System.gc();
        }
    }

}
