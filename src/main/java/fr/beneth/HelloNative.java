package fr.beneth;

public class HelloNative {
    static {
        String nativeLibPath = HelloNative.class.getResource("/native/hellonative.so").getFile();
        System.load(nativeLibPath);
    }

    native void helloNative();

    static public void main(String argv[]) {
        HelloNative helloWorld = new HelloNative();
        helloWorld.helloNative();

    }
}
