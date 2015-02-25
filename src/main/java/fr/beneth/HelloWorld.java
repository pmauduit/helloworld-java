package fr.beneth;

import java.io.IOException;


public class HelloWorld {

    public static void runJRuby() throws IOException {
        RubyEmbedded rb = new RubyEmbedded(HelloWorld.class.getResource("/helloworld.rb").getFile());
        rb.run();        
    }
    
    public static void runNative(String argv[]) {
        HelloNative.main(argv);
    }
    
	public static void main(String args[]) throws IOException {
	    HelloWorld.runNative(args);
	}
}
