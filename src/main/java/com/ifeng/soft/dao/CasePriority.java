package com.ifeng.soft.dao;


import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CasePriority {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<String> list = new ArrayList<>();
//        FutureTask<Integer> futureTask = new FutureTask<>(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                return null;
//            }
//        });
//        futureTask.get();
//        new Thread(()-> System.out.println("")).start();
//        AtomicInteger m = new AtomicInteger();
//        list.forEach(t->{
//          m.getAndIncrement();
//        });
////        JSONObject jsonObject = new JSONObject();
////        Object s = jsonObject.get("aa");
////        s.toString();
//    }
public static void main(String[] args) {
    BigDecimal bigDecimal = new BigDecimal(0);
    List<BigDecimal> bigDecimals = new ArrayList<>();
    bigDecimals.add(BigDecimal.valueOf(10));
    for (BigDecimal big:bigDecimals) {
        bigDecimal =bigDecimal.add(big);
    }
    System.out.println(bigDecimal);

}

}
