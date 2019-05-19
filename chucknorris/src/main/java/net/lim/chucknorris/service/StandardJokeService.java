package net.lim.chucknorris.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class StandardJokeService implements JokeService {


    private ChuckNorrisQuotes quotes;

    public StandardJokeService(ChuckNorrisQuotes quotes) {
        this.quotes = quotes;
    }

    @Override
    public String getRandomJoke() {
        return quotes.getRandomQuote();
    }
}
