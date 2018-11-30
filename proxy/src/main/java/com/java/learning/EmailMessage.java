package com.java.learning;

public class EmailMessage implements MessageHandler {
    @Override
    public void sendMessage(String msg) {
        System.out.println("email: " + msg);
    }
}
