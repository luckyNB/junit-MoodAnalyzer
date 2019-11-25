package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_whenSad_shouldReturnSad() {
        MoodAnalyzer moodAnayzer = new MoodAnalyzer("HAPPY");
        String currentMood = null;
        try {
            currentMood = moodAnayzer.analyzeMood("This is sad message");
            Assert.assertEquals("SAD", currentMood);
        } catch (MoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMessage_whenHappy_shouldReturnSad() {

        MoodAnalyzer moodAnayzer = new MoodAnalyzer("SAD");
        String currentMood = null;
        try {
            currentMood = moodAnayzer.analyzeMood("This is a happy message");
            Assert.assertEquals("HAPPY", currentMood);
        } catch (MoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMessage_whenNull_shouldReturnHappy() {
        MoodAnalyzer moodAnayzer = new MoodAnalyzer(null);
        try {
            moodAnayzer.analyzeMood(null);
        } catch (MoodException e) {
            Assert.assertEquals("Please enter proper mood", e.getMessage());
        }

    }

    @Test
    public void givenMessage_WhenEmpty_shouldReturnProperMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodException.class);
            moodAnalyzer.analyzeMood("");
        } catch (MoodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() throws MoodException {
        MoodAnalyzer moodAnalyzer = null;
        try {
            moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in Mood-Analyzer Factorey");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);

    }


    @Test
    public void givenNullDumpShould_Throw_Exception() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("HAPPY");
        String dump = ObjectReflector.dump(moodAnalyzer, 0);
        Assert.assertEquals("HAPPY",dump);
    }
}
