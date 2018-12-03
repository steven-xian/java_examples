import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 1111);

        serverSocketChannel.bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);

        int ops = serverSocketChannel.validOps();
        SelectionKey selectionKey = serverSocketChannel.register(selector, ops, null);

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();

            while(selectionKeyIterator.hasNext()) {
                SelectionKey key = selectionKeyIterator.next();
                if (key.isValid() && key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Connection Accepted: " + socketChannel.getLocalAddress());
                } else if (key.isValid() && key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    int count = socketChannel.read(buffer);
                    if (count == -1) {
                        System.out.println("client is disconnected.");
                        socketChannel.close();
                        selectionKeyIterator.remove();
                        continue;
                    }

                    String result = new String(buffer.array()).trim();
                    System.out.println("Message received: " + result);
                    if (result.equalsIgnoreCase("bye")) {
                        socketChannel.close();
                    }

                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                }
                selectionKeyIterator.remove();
            }
        }
    }
}
