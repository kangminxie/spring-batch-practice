package com.kangmin.app.writer;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;

public class ConsoleItemWriter extends AbstractItemStreamItemWriter<Integer> {

    @Override
    public void write(List items) throws Exception {
        items.forEach(System.out::println);
        System.out.println("************** writing each chunk **************");
    }
}
