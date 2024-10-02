package com.sigap.SIGAP.download.controller;

import com.sigap.SIGAP.afiliado.entity.Afiliado;
import com.sigap.SIGAP.download.service.DownloadServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/download")
@RequiredArgsConstructor
public class DownloadController {

    private final DownloadServiceImpl downloadService;

    @GetMapping("/all-data")
    public ResponseEntity<InputStreamResource> downloadAllData() {
        String data = downloadService.generateAllDataAsString();

        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=ACO245RACOAAAMMDDNI999999999999.txt");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.TEXT_PLAIN)
                .body(new InputStreamResource(in));
    }
}