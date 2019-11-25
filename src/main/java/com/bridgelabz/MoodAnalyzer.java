package com.bridgelabz;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String message) throws MoodException {
        this.message = message;
        return message;
    }


    public String analyzeMood() throws MoodException {
        try {

            if (message.isEmpty())
                return "HAPPY";
            else
                return "SAD";

        } catch (NullPointerException e) {
            throw new MoodException("Please enter proper message");
        }
    }
}
