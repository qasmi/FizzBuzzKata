package com.kata.fizzbuzz.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FizzBuzzGame {

        private static final String FIZZ = "fizz";
        private static final String BUZZ = "buzz";
        private static final String POP = "pop" ;
        private List<Resolver> basicPatterns = Arrays.asList(this::isFizz, this::isBuzz, this::isPop);

        public String play(int number){

                return basicPatterns.stream()
                        .map(pattern -> pattern.resolve(number))
                        .filter(resolvedToken-> resolvedToken.isPresent())
                        .map(resolvedToken -> resolvedToken.get())
                        .reduce((firstToken, secondToken) -> firstToken + " " + secondToken)
                        .orElse(new Integer(number).toString());
        }

        public String play(int number, Map<String, Integer> customPatterns){

                return customPatterns.entrySet().stream()
                        .map(s -> isSubstitution(number, s.getValue(), s.getKey()))
                        .filter(resolvedToken-> resolvedToken.isPresent())
                        .map(resolvedToken -> resolvedToken.get())
                        .reduce((firstToken, secondToken) -> firstToken + " " + secondToken)
                        .orElse(new Integer(number).toString());
        }

        private Optional<String> isFizz(int number) {
                return Optional.ofNullable(number % 3 == 0 ? FIZZ : null);
        }

        private Optional<String> isBuzz(int number) {
                return Optional.ofNullable(number % 5 == 0 ? BUZZ : null);
        }

        private Optional<String> isPop(int number) {
                return Optional.ofNullable(number % 7 == 0 ? POP : null);
        }

        @FunctionalInterface
        public interface Resolver {
                Optional<String> resolve(int number);
        }

        private Optional<String> isSubstitution(int number, int multiple, String substitution) {
                return Optional.ofNullable(number % multiple == 0 ? substitution : null);
        }
}
