package com.ifeng.soft.bean;

import com.sun.deploy.net.proxy.ProxyHandler;
import org.assertj.core.util.Lists;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangfu
 * @description TODO
 * @date 2022/3/25 8:35 下午
 **/
public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke" + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke" + method.getName());
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, URISyntaxException {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Student student = new Student();
        InvocationHandler invocationHandler = new DynamicProxy(student);
        Person person = (Person) Proxy.newProxyInstance(student.getClass().getClassLoader(),
                student.getClass().getInterfaces(),
                invocationHandler);
        person.rentingHouse();
        Method m3 = Class.forName("com.ifeng.soft.bean.Person").getMethod("rentingHouse");
        m3.invoke(student,null);


        byte[] s = new byte[]{42, -76, 0, 16, 42, -78, 0, 20, 4, -67, 0, 22, 89, 3, 43, 83, -71, 0, 28, 4, 0, -64, 0, 30, -74, 0, 34, -84, -65, 77, -69, 0, 42, 89, 44, -73, 0, 45, -65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Files.write(Paths.get("","o.txt"), s, new OpenOption[0]);
//        String oo = new String(s);
//        System.out.println(oo);
        Set<Long> set = new HashSet<>();
        List<Long> longList = Lists.newArrayList(set);
    }
}
