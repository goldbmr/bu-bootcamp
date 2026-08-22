import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    private static int invalidCount = 0;
    // Step 1: read scores from file
    public static void main(String[] args) {
        String filename = "scores.txt";
        invalidCount = 0;
        ArrayList<Integer> scores = readScores(filename);
        
    // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > high) {
                high = score;
            }
            if (score < low) {
                low = score;
            }
        }
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        if (scores.isEmpty()) {
            high = 0;
            low = 0;
            System.out.println("Invalid scores.");
        }
        else {
            System.out.println("Average score: " + avg);
            System.out.println("Highest score: " + high);
            System.out.println("Lowest score: " + low);
        }

        writeReport(scores, avg, high, low, "report.txt", countA, countB, countC, countD, countF);
    }

    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) {
                    continue;
                }
                try {
                    int score = Integer.parseInt(trimmedLine);
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    } else {
                        System.out.println("Invalid score: " + score);
                    }
                } catch (NumberFormatException e) {
                    invalidCount++;
                    System.out.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }
        return total / scores.size();
    }
    // Step 3: write and print report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile,
                                   int countA, int countB, int countC, int countD, int countF) {
        StringBuilder report = new StringBuilder();
        report.append("=== Grade Analysis Report ===\n");
        report.append(String.format("Total scores processed: %3d%n", scores.size()));
        report.append(String.format("Invalid lines skipped:  %3d%n", invalidCount));
        report.append("\n");
        report.append(String.format("Average score: %6.2f%n", avg));
        report.append(String.format("Highest score: %6d%n", high));
        report.append(String.format("Lowest score:  %6d%n", low));
        report.append("\n");
        report.append("Grade distribution:\n");
        report.append(String.format("  A (90-100):   %d%n", countA ));
        report.append(String.format("  B (80-89):    %d%n", countB));
        report.append(String.format("  C (70-79):    %d%n", countC));
        report.append(String.format("  D (60-69):    %d%n", countD));
        report.append(String.format("  F (below 60): %d%n", countF));

        System.out.print(report.toString());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report.toString());
        } catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
        }
    }
} 