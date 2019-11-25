package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class ObjectReflectorTest {

    @Test
    public void givenNullDumpShould_Throw_Exception() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Mood Analyzer Class");
        String dump = ObjectReflector.dump(moodAnalyzer, 0);

    }
}
