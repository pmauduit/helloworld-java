package fr.beneth;

import java.io.IOException;

import com.sun.jna.Library;
import com.sun.jna.Native;


public class HelloWorld {

    public interface MapserverLibrary extends Library {
        MapserverLibrary INSTANCE = (MapserverLibrary) Native.loadLibrary(
                "mapserver", MapserverLibrary.class);

        // nm -D /usr/lib/x86_64-linux-gnu/libmapserver.so | grep T | less

        String msGetVersion();

    }

	public static void main(String args[]) throws IOException {
		System.out.println(MapserverLibrary.INSTANCE.msGetVersion());
	}
}
