// WinnerService.java
package com.example.winner.service;

import com.example.winner.model.Winner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class WinnerService {
    private List<Winner> winners = new ArrayList<>();

    public void loadCSV(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            winners = br.lines()
                    .skip(1) // Skip header
                    .map(line -> {
                        String[] data = line.split(",");
                        return new Winner(data[0], data[1]);
                    })
                    .collect(Collectors.toList());
        }
    }

    public Winner getRandomWinner() {
        if (winners.isEmpty()) {
            throw new IllegalArgumentException("No winners available to choose from.");
        }
        Random random = new Random();
        return winners.get(random.nextInt(winners.size()));
    }
}
