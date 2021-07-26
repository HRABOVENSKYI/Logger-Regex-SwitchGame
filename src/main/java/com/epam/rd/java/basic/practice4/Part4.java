package com.epam.rd.java.basic.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.rd.java.basic.practice4.Part1.readFile;

public class Part4 implements Iterable<Object> {

    public static void main(String[] args) {
        Part4 part4 = new Part4();
        IteratorImpl iterator = (IteratorImpl) part4.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    public class IteratorImpl implements Iterator<Object> {
        Pattern pattern = Pattern.compile("(\\p{Lu}.+?[.!?])");
        Matcher matcher = pattern.matcher(readFile("part4.txt"));

        @Override
        public boolean hasNext() {
            return matcher.find();
        }

        @Override
        public Object next() {
            if (matcher.groupCount()>0) {
                return matcher.group().replace(System.lineSeparator(), " ");
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
