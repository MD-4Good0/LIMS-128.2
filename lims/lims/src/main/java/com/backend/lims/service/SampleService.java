package com.backend.lims.service;

import com.backend.lims.model.Sample;
import com.backend.lims.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public List<Sample> getSamplesByRequestId(Long requestId) {
        return sampleRepository.findByRequestRequestId(requestId);
    }

    public List<Long> getSampleIdsByRequestId(Long requestId) {
        return sampleRepository.findSampleIdsByRequestId(requestId);
    }

}