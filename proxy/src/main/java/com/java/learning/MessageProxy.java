package com.java.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MessageProxy implements InvocationHandler {
    private static int count;
    private MessageHandler messageHandler;

    public MessageProxy(MessageHandler handler) {
        messageHandler = handler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("proxy send:");
        return method.invoke(messageHandler, args);
    }
}
