package com.kangmin.app.reader;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;

import java.util.Arrays;
import java.util.List;

public class InMemReader extends AbstractItemStreamItemReader<Integer> {

    final Integer[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 10};
    final List<Integer> myList = Arrays.asList(arr);

    int index = 0;

    @Override
    public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Integer nextItem = null;
        if (index < myList.size()) {
            nextItem = myList.get(index);
            index++;
        } else {
            index = 0;
        }
        return nextItem;
    }
}
