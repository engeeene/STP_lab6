public class Metrics {
    //private static long timeUsed = 0;
    //private static long memoryUsed = 0;

    public Metrics() {}

    private static long timeStart = 0;
    private static long memoryStart = 0;
    private static long timeEnd = 0;
    private static long memoryEnd = 0;

    public static void start() {
        timeStart = System.nanoTime();
        memoryStart = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    }

    public static void stop() {
        timeEnd = System.nanoTime();
        memoryEnd = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    }

    public static double getTime() {
        return (double)(timeEnd - timeStart)/1000000000;
    }

    public static double getMemory() {
        return (double)(memoryEnd - memoryStart)/1024/1024;
    }

    public static void clear(){
        timeStart = 0;
        memoryStart = 0;
        timeEnd = 0;
        memoryEnd = 0;
    }
}
