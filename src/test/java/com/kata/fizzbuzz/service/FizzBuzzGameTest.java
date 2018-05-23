package com.kata.fizzbuzz.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class FizzBuzzGameTest {

        private FizzBuzzGame resolver = new FizzBuzzGame();

        @Test
        public void play_should_return_fizz(){

                Assertions.assertThat(resolver.play(3)).isEqualTo("fizz");
                Assertions.assertThat(resolver.play(9)).isEqualTo("fizz");
                Assertions.assertThat(resolver.play(123)).isEqualTo("fizz");
        }

        @Test
        public void play_should_return_buzz(){

                Assertions.assertThat(resolver.play(5)).isEqualTo("buzz");
                Assertions.assertThat(resolver.play(20)).isEqualTo("buzz");
                Assertions.assertThat(resolver.play(200)).isEqualTo("buzz");
        }

        @Test
        public void play_should_return_pop(){

                Assertions.assertThat(resolver.play(7)).isEqualTo("pop");
                Assertions.assertThat(resolver.play(28)).isEqualTo("pop");
                Assertions.assertThat(resolver.play(77)).isEqualTo("pop");
        }

        @Test
        public void play_should_return_fizzbuzz(){

                Assertions.assertThat(resolver.play(15)).isEqualTo("fizz buzz");
                Assertions.assertThat(resolver.play(45)).isEqualTo("fizz buzz");
        }

        @Test
        public void play_should_return_fizzbuzzpop(){

                Assertions.assertThat(resolver.play(105)).isEqualTo("fizz buzz pop");
                Assertions.assertThat(resolver.play(210)).isEqualTo("fizz buzz pop");
                Assertions.assertThat(resolver.play(315)).isEqualTo("fizz buzz pop");
        }

        @Test
        public void play_should_return_fizzpop(){

                Assertions.assertThat(resolver.play(21)).isEqualTo("fizz pop");
                Assertions.assertThat(resolver.play(63)).isEqualTo("fizz pop");
                Assertions.assertThat(resolver.play(126)).isEqualTo("fizz pop");
        }

        @Test
        public void play_should_return_buzzpop(){

                Assertions.assertThat(resolver.play(35)).isEqualTo("buzz pop");
                Assertions.assertThat(resolver.play(70)).isEqualTo("buzz pop");
                Assertions.assertThat(resolver.play(140)).isEqualTo("buzz pop");
        }

        @Test
        public void play_should_return_127(){

                Assertions.assertThat(resolver.play(127)).isEqualTo("127");
        }

        @Test
        public void play_should_use_custom_multiple_to_return_custom_substitution(){

                Map<String, Integer> customPatterns = new LinkedHashMap<>();
                customPatterns.put("fuzz", new Integer(2));
                customPatterns.put("bizz", new Integer(3));

                Assertions.assertThat(resolver.play(1, customPatterns)).isEqualTo("1");
                Assertions.assertThat(resolver.play(2, customPatterns)).isEqualTo("fuzz");
                Assertions.assertThat(resolver.play(8, customPatterns)).isEqualTo("fuzz");

                Assertions.assertThat(resolver.play(4, customPatterns)).isEqualTo("fuzz");
                Assertions.assertThat(resolver.play(9, customPatterns)).isEqualTo("bizz");
                Assertions.assertThat(resolver.play(12, customPatterns)).isEqualTo("fuzz bizz");
        }
}
