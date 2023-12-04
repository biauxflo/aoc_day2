package com.aoc.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise1 {
    public static class Game {
        int number;
        int maxRed;
        int maxGreen;
        int maxBlue;

        public Game() {
            this.number = 0;
            this.maxRed = 0;
            this.maxGreen = 0;
            this.maxBlue = 0;
        }

        public int getNumber() {
            return number;
        }

        public int getMaxRed() {
            return maxRed;
        }

        public int getMaxGreen() {
            return maxGreen;
        }

        public int getMaxBlue() {
            return maxBlue;
        }

        public void fromString(String str) {
            String[] parts = str.split(":");
            this.number = Integer.parseInt(parts[0].split("\\s+")[1]);
            String[] maxParts = parts[1].split(";");
            for (String maxPart : maxParts) {
                String[] colorParts = maxPart.split(",");
                for(String colorPart : colorParts) {
                    String[] max = colorPart.trim().split("\\s+");
                    switch (max[1]) {
                        case "red" -> this.maxRed = Math.max(Integer.parseInt(max[0]), this.maxRed);
                        case "green" -> this.maxGreen = Math.max(Integer.parseInt(max[0]), this.maxGreen);
                        case "blue" -> this.maxBlue = Math.max(Integer.parseInt(max[0]), this.maxBlue);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        AtomicInteger sum = new AtomicInteger();
        Files.readAllLines(Paths.get("day2/src/main/resources/com/aoc/day2/input.txt")).forEach(line -> {
            Game game = new Game();
            game.fromString(line);

            // Part 1
            //if (game.getMaxRed() <= 12 && game.getMaxGreen() <= 13 && game.getMaxBlue() <= 14) {
            //    sum.addAndGet(game.getNumber());
            //}

            // Part 2
            sum.addAndGet(game.getMaxBlue()*game.getMaxGreen()*game.getMaxRed());
        });
        System.out.println(sum);
    }
}
