package ikhoon

import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import ikhoon.thriftscala.{EchoService, Pong}

/**
  * Created by ikhoon on 13/08/2017.
  */
object Server {
  val server = Thrift.server.serveIface(
    "localhost:1234",
    new EchoService[Future] {
      def ping(name: String): Future[Pong] =
        Future.value(Pong(name, Some(10)))

      def tell(name: String): Future[String] =
        Future.value(s"hello $name!")

    }
  )

  def main(args: Array[String]): Unit = {
    println("Start thrift server on 1234 port...")
    Await.result(server)
  }
}
