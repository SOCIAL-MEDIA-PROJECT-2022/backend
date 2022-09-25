package com.revature.controllers;


import com.revature.annotations.Authorized;
import com.revature.dtos.SearchReturn;
import com.revature.services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SearchController {

    private static final Logger logger = Logger.getLogger(SearchController.class.getName());
    private static final Level logLevel = Level.INFO;

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @Authorized
    @GetMapping("/{val}")
    public ResponseEntity<List<SearchReturn>> search(@PathVariable String val) {

        logger.log(logLevel, "made it with : " + val);
        return ResponseEntity.ok(this.searchService.search(val));


    }


}
