package com.backend.lims.controller;

import com.backend.lims.model.Sample;
import com.backend.lims.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleController {
    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    // Endpoint to get samples by requestId
    @GetMapping("/request/{requestId}")
    public List<Sample> getSamplesByRequestId(@PathVariable Long requestId) {
        System.out.println(requestId);
        return sampleService.getSamplesByRequestId(requestId);
    }

    // How do I track which sample Ids for the request
    @GetMapping("/request/ids/{requestId}")
    public List<Long> getSampleIdsByRequestId(@PathVariable Long requestId) {
        return sampleService.getSampleIdsByRequestId(requestId);
    }
}