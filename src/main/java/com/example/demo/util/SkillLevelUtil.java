package com.example.demo.util;

public class SkillLevelUtil {

    public static int levelRank(String l) {
        return switch (l) {
            case "BEGINNER" -> 1;
            case "INTERMEDIATE" -> 2;
            case "EXPERT" -> 3;
            default -> 0;
        };
    }

    public static int priorityRank(String p) {
        return switch (p) {
            case "HIGH" -> 3;
            case "MEDIUM" -> 2;
            case "LOW" -> 1;
            default -> 0;
        };
    }
}
