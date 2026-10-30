package com.plushchan.urlshortener.controller;

import com.plushchan.urlshortener.model.URLRedirect;
import com.plushchan.urlshortener.service.URLRedirectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class URLRedirectController {
    public URLRedirectService urlRedirectService;

    public URLRedirectController(URLRedirectService urlRedirectService) {
        this.urlRedirectService = urlRedirectService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<URLRedirect> redirectToURL(@PathVariable String code) {
        String url = urlRedirectService.getURLRedirect(code).getUrl();

        return ResponseEntity
                .status(302)
                .location(URI.create(url))
                .build();
    }
}
