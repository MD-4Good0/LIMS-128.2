package com.backend.lims.repository;

import java.util.List;

import com.backend.lims.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.lims.model.Client;
import com.backend.lims.model.Request;
import com.backend.lims.model.Request.RequestStatus;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	List<Request> findByRequestStatus(RequestStatus status);
    List<Request> findByClient(Client client);
    Request findByRequestId(Long requestId);
    List<Request> findByRepresentativeId(Long representativeId);
    List<Request> findByRepresentativeName(String representativeName);
}