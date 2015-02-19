package fr.beneth;

import java.io.IOException;


public class HelloWorld {

	public static void main(String args[]) throws IOException {
		RubyEmbedded rb = new RubyEmbedded(HelloWorld.class.getResource("/helloworld.rb").getFile());
		rb.run();
	}
}
