package com.paulmdavies.fallout4;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {
    @Test
    public void testSimilarityBetweenWordsShouldBeTheNumberOfCharactersTheyShareInTheSamePosition() {
        Word foo = new Word("Foo");
        Word boo = new Word("Boo");
        assertEquals(foo.similarity(boo), 2);
    }

    @Test
    public void testSiumilarityShouldBeCalculatedRegardlessOfCase() {
        Word foo = new Word("Foo");
        Word far = new Word("far");
        assertEquals(foo.similarity(far), 1);
    }
}