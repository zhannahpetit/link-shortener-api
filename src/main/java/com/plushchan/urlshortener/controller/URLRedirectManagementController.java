package com.plushchan.urlshortener.controller;

import com.plushchan.urlshortener.dto.URLRedirectDTO;
import com.plushchan.urlshortener.model.URLRedirect;
import com.plushchan.urlshortener.service.URLRedirectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/url")
public class URLRedirectManagementController {
    private URLRedirectService urlRedirectService;

    public URLRedirectManagementController(URLRedirectService urlRedirectService) {
        this.urlRedirectService = urlRedirectService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<URLRedirect> getURLRedirect(@PathVariable String code) {
        URLRedirect url = urlRedirectService.getURLRedirect(code);

        return ResponseEntity.ok(url);
    }

    @GetMapping
    public ResponseEntity<List<URLRedirect>> getAllURLRedirects() {
        List<URLRedirect> urlRedirects = urlRedirectService.getAllURLRedirects();

        return ResponseEntity.ok(urlRedirects);
    }

    @PostMapping
    public ResponseEntity<URLRedirect> createURLRedirect(@RequestBody URLRedirectDTO dto) {
        URLRedirect url = urlRedirectService.createURLRedirect(dto);

        return ResponseEntity.created(URI.create("/" + url.getCode())).body(url);
    }

    @PutMapping("/{code}")
    public ResponseEntity<URLRedirect> updateURLRedirect(
            @PathVariable String code,
            @RequestBody URLRedirectDTO dto
    ) {
        URLRedirect url = urlRedirectService.updateURLRedirect(code, dto);

        return ResponseEntity.ok(url);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<URLRedirect> removeURLRedirect(@PathVariable String code) {
        urlRedirectService.removeURLRedirect(code);

        return ResponseEntity.noContent().build();
    }
}
