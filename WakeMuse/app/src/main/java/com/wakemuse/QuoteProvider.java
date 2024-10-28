package com.wakemuse;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuoteProvider {
    private static final List<String> quotes = Arrays.asList(
            "Believe in yourself!",
            "You are capable of amazing things.",
            "Success is not final; failure is not fatal: It is the courage to continue that counts.",
            "The only limit to our realization of tomorrow is our doubts of today.",
            "Believe you can and you're halfway there."
    );

    public static String getRandomQuote() {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }
}
