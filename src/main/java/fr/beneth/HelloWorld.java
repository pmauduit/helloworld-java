package fr.beneth;

import java.net.URL;

import com.sun.jna.Library;
import com.sun.jna.Native;


public class HelloWorld {

    public interface V8Library extends Library {
        public URL callv8LibUrl = V8Library.class.getResource("/native/callv8.so");

        public static V8Library INSTANCE = (V8Library) Native.loadLibrary(callv8LibUrl.getFile(), V8Library.class);

        String js_eval(String jsScript);
    }

    public interface MapserverLibrary extends Library {
        public static MapserverLibrary INSTANCE = (MapserverLibrary) Native.loadLibrary(
                "mapserver", MapserverLibrary.class);

        // nm -D /usr/lib/x86_64-linux-gnu/libmapserver.so | grep T | less

        String msGetVersion();

    }

    public static void main(String args[]) throws Exception {
        System.out.println("\n\n\nJava -> JNA -> C++ -> V8 -> Javascript -> Java PoC\n\n\n");
        String JS_PAYLOAD = "function hw() { return \"Helloworld\"; }; hw();";
        System.out.println("\nNative library being loaded: " + V8Library.callv8LibUrl.getFile());
        System.out.println("Executing JS code: " + JS_PAYLOAD);
        String ret = V8Library.INSTANCE.js_eval(JS_PAYLOAD);
        System.out.println("Returned string: " + ret);
        System.out.println("\n\n\n");
    }

}
