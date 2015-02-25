#include <stdio.h>
#include <stdlib.h>

#include "fr_beneth_HelloNative.h"

#define ALLOCATION_SIZE 0xffff

void * p = NULL;

JNIEXPORT void JNICALL Java_fr_beneth_HelloNative_helloNative
  (JNIEnv * env, jobject obj) {

  fprintf(stdout, "Hello World, obj is at %x, env is at %x\n", &obj, env);
  fprintf(stdout, "Allocating some space in memory ...");
  p = calloc(1, ALLOCATION_SIZE);
  fprintf(stdout,"memory available for use at %x\n");
  fprintf(stdout, "allocation done.\n");

  return;
}


