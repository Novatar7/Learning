// WinnerController.java
package com.example.winner.controller;

import com.example.winner.model.Winner;
import com.example.winner.service.WinnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
@Slf4j
public class WinnerController {
    @Autowired
    private WinnerService winnerService;

    @PostMapping("upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        try {
            winnerService.loadCSV(file.getOriginalFilename());
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("winner")
    public ResponseEntity<Winner> getWinner() {
        try {
            Winner winner = winnerService.getRandomWinner();
            return ResponseEntity.ok(winner);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
