package com.plushchan.urlshortener.service;

import com.plushchan.urlshortener.dto.URLRedirectDTO;
import com.plushchan.urlshortener.model.URLRedirect;
import com.plushchan.urlshortener.repository.URLRedirectRepository;
import com.plushchan.urlshortener.util.CodeGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class URLRedirectService {
    URLRedirectRepository urlRedirectRepository;

    public URLRedirect getURLRedirect(String code) {
        return urlRedirectRepository.findByCode(code);
    }

    public URLRedirect createURLRedirect(URLRedirectDTO dto) {
        String code = CodeGenerator.generateCode();

        URLRedirect url_instance = new URLRedirect();
        url_instance.setCode(code);
        url_instance.setUrl(dto.url());

        return urlRedirectRepository.save(url_instance);
    }

    public List<URLRedirect> getAllURLRedirects() {
        return urlRedirectRepository.findAll();
    }

    public URLRedirect updateURLRedirect(String code, URLRedirectDTO dto) {
        URLRedirect url = urlRedirectRepository.findByCode(code);

        url.setUrl(dto.url());

        return urlRedirectRepository.save(url);
    }

    public void removeURLRedirect(String code) {
        urlRedirectRepository.delete(urlRedirectRepository.findByCode(code));
    }
}
