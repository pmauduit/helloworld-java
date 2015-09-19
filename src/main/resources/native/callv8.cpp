#include <iostream>
#include <string>
#include <v8.h>

// g++ -o callv8.so callv8.cpp -fPIC -shared -lv8

using namespace v8;

extern "C" {
  char * js_eval(char *);
}

char * js_eval(char * str_script) {
  std::string * ret;

  V8::Initialize();
  {
    HandleScope handle_scope;
    Persistent<Context> context = Context::New();
    Context::Scope context_scope(context);

    context->Enter();

    Handle<String> source;
    Handle<Script> script;
    Handle<Value> result;

    // v8 does not ship any of these "standard" facilities
    // It sounds like bare metal javascript syntax is supported :(
    //source = String::New("console.log(\"Helloworld\");");
    source = String::New(str_script);

    script = Script::Compile(source);
    result = script->Run();

    String::AsciiValue ascii(result);
    ret = new std::string(*ascii);
    context->Exit();
    context.Dispose();
  }
  V8::Dispose();
  return (char *) const_cast<char*> (ret->c_str());
}

