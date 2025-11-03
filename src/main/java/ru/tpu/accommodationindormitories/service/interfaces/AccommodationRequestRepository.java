package ru.tpu.accommodationindormitories.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.AccommodationRequest;

public interface AccommodationRequestRepository extends JpaRepository<AccommodationRequest, Long> {
}
