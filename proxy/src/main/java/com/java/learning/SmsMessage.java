package com.java.learning;

public class SmsMessage implements MessageHandler {
    @Override
    public void sendMessage(String msg) {
        System.out.println("Sms: " + msg);
    }
}
