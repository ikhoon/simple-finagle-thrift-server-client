package ikhoon;

import com.twitter.finagle.Thrift;
import com.twitter.util.Await;
import com.twitter.util.Duration;
import com.twitter.util.Future;
import org.junit.Test;
import ikhoon.thriftjava.EchoService;
import ikhoon.thriftjava.Pong;

/**
 * Created by ikhoon on 13/08/2017.
 */
public class EchoClientTest {
    @Test
    public void testEcho() throws Exception {
        EchoService.ServiceIface service = Thrift.client().newIface("localhost:1234", EchoService.ServiceIface.class);
        Future<Pong> hello = service.ping("hello");
        Pong result = Await.result(hello, Duration.fromSeconds(5));
        System.out.println(result);
    }
}
