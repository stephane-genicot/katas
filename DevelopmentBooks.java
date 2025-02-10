package com.bnpp.kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DevelopmentBooks {

	private static final int BOOK_PRICE = 50;

    public double finalPrice(Map<String, Integer> booksAndQuans) {
        double totalPrice = 0.0;
        
        while (!booksAndQuans.isEmpty()) {
            Set<String> uniqueBooks = booksAndQuans.keySet().stream().collect(Collectors.toSet());
            int uniqueBookCount = uniqueBooks.size();
            
            if(uniqueBookCount == 2)
            	totalPrice += uniqueBookCount * BOOK_PRICE - (uniqueBookCount * BOOK_PRICE * 0.05);
            else if(uniqueBookCount == 3)
            	totalPrice += uniqueBookCount * BOOK_PRICE - (uniqueBookCount * BOOK_PRICE * 0.1);
            else if(uniqueBookCount == 4)
            	totalPrice += uniqueBookCount * BOOK_PRICE - (uniqueBookCount * BOOK_PRICE * 0.2);
            else if(uniqueBookCount == 5)
            	totalPrice += uniqueBookCount * BOOK_PRICE - (uniqueBookCount * BOOK_PRICE * 0.25);
            else
            	totalPrice += uniqueBookCount * BOOK_PRICE;

            for (String book : uniqueBooks) {
            	booksAndQuans.put(book, booksAndQuans.get(book) - 1);
                if (booksAndQuans.get(book) == 0) {
                	booksAndQuans.remove(book);
                }
            }
        }

        return totalPrice;
    }

}
