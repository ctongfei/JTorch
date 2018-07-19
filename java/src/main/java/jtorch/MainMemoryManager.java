package jtorch;

/**
 * Manages objects on the main memory but allocated off-heap.
 * @author Tongfei Chen
 */
public class MainMemoryManager extends MemoryManager<MainMemoryNativeObject> {

    private MainMemoryManager() { }

    static public MainMemoryManager INSTANCE = new MainMemoryManager();

}
