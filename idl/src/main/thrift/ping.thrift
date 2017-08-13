#@namespace scala ikhoon.thriftscala
namespace java ikhoon.thriftjava

struct Pong {
  1: required string name;
  2: optional i32 id;
}

service EchoService {
  Pong ping(string name)
  string tell(string name)
}