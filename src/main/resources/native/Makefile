jni-compile: hellonative.so

hellonative.so:
	gcc -O3 -fPIC -shared -I $(JAVA_HOME)/include/ \
	    -I $(JAVA_HOME)/include/linux/ \
	    hellonative.c -o hellonative.so

clean:
	rm -f hellonative.so

.PHONY: clean jni-compile
