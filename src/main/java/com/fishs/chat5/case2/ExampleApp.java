package com.fishs.chat5.case2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/24 17:05
 */
public class ExampleApp {

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName() .equals("sayHello")) {
                    System.out.println("Hello " + args[0]);
                }
                if (method.getName() .equals("sayGoodbye")) {
                    System.out.println("Goodbye " + args[0]);
                }
                return null;
            }
        };
        People people = (People) java.lang.reflect.Proxy.newProxyInstance(
                People.class.getClassLoader(),
                new Class[]{People.class},
                handler
        );
        people.sayGoodbye("张三");

    }
}

interface People{
    void sayHello(String name);
    void sayGoodbye(String  name);
}
