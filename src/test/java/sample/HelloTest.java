package sample;


import org.junit.Before;
import org.junit.Test;
import sample.Hello.HelloResponse;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class HelloTest {
    private MessageDao messageDao;
    private Hello hello;

    @Before
    public void setUp() throws Exception {
        messageDao = mock(MessageDao.class);
        hello = new Hello();
        hello.messageDao = messageDao;
    }

    @Test
    public void test_sayHello() throws Exception {
        Message message = new Message();
        message.id = 1L;
        message.template = "Hello, %s!";
        when(messageDao.select(1L)).thenReturn(message);

        HelloResponse said = hello.sayHello("world");
        assertThat(said.getMessage(), is("Hello, world!"));

        verify(messageDao).select(1L);
    }

}
