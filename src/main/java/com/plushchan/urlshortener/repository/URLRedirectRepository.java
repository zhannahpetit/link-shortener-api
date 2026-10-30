package com.plushchan.urlshortener.repository;

import com.plushchan.urlshortener.model.URLRedirect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRedirectRepository extends JpaRepository<URLRedirect, Long> {
    URLRedirect findByCode(String code);
}
