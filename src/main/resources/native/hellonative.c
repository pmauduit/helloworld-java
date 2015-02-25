#include <stdio.h>
#include "fr_beneth_HelloNative.h"

JNIEXPORT void JNICALL Java_fr_beneth_HelloNative_helloNative
  (JNIEnv * env, jobject obj) {

  fprintf(stdout, "Hello World, obj is at %x\n", &obj);
}

