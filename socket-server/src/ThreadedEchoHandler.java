import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket i) {
        incoming = i;
    }

    @Override
    public void run() {
        try {
            try {
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                Scanner in = new Scanner(inputStream, "UTF-8");
                PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                out.println("Hello! Enter BYE to exit.");
                boolean done = false;
                while(!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    out.println("Echo: " + line);
                    if (line.trim().equalsIgnoreCase("BYE")) {
                        done = true;
                    }
                }
            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
