package com.java.learning;


import java.lang.reflect.Proxy;

public class App
{
    public static void main( String[] args )
    {
        MessageHandler handler = new EmailMessage();
        handler.sendMessage("hello email");

        MessageHandler proxy = (MessageHandler) Proxy.newProxyInstance(MessageHandler.class.getClassLoader(),
                new Class[] {MessageHandler.class}, new MessageProxy(handler));
        proxy.sendMessage("hello proxy email");

        MessageHandler smsHandler = new SmsMessage();
        MessageHandler smsProxy = (MessageHandler) Proxy.newProxyInstance(MessageHandler.class.getClassLoader(),
                new Class[] {MessageHandler.class}, new MessageProxy(smsHandler));
        smsProxy.sendMessage("hello proxy sms");
    }
}
