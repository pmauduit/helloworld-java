package fr.beneth;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jruby.embed.ScriptingContainer;

public class RubyEmbedded {

	private String script ;
	public RubyEmbedded(String script) {
		this.script = script;
		

	}
	
	public void run() throws IOException {
		if ((script == null) || (! new File(script).exists())) {
			throw new RuntimeException("script is null or script not found.");
		}
		ScriptingContainer  ruby = new ScriptingContainer();
		ruby.runScriptlet(FileUtils.readFileToString(new File(script)));
	}
}
