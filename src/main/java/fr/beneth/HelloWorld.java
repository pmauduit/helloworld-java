package fr.beneth;

import java.net.URL;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;


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
    
    public interface Osm2PgsqlLib extends Library {
        /*
         * How to generate this libosm2pgsql.so lib (osm2pgsql is an executable and has not been
         * thought to be a shared library):
         * Make sure you added the following directive in the CMakeLists.txt from osm2pgsql somewhere:
         *   set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fPIC"  )
         * Then compile, it should generate a libosm2pgsql.a file in the build dir ;
         * $ ar x libosm2pgsql.a
         * This should decompress the archive of all the the object files from the previous compilation
         * Then:
         * $ gcc --shared -o libosm2pgsql.so *.o
         * The file is 21MB large, so obviously I won't commit it in the git repository
         */
        public URL Osm2PgsqlLibUrl = Osm2PgsqlLib.class.getResource("/native/libosm2pgsql.so");

        public static Osm2PgsqlLib INSTANCE = 
                (Osm2PgsqlLib) Native.loadLibrary(Osm2PgsqlLibUrl.getFile(), Osm2PgsqlLib.class);
        Pointer _ZTI9options_t(int argc, String[] argv);

        String main(int argc, String[] argv);
    }

    public static void main(String args[]) throws Exception {
        System.out.println(Osm2PgsqlLib.Osm2PgsqlLibUrl.toString());
        Osm2PgsqlLib.INSTANCE._ZTI9options_t(1, new String[] { "blah" });

    }

}
