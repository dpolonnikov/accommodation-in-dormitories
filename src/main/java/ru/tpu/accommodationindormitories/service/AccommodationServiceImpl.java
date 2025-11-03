package ru.tpu.accommodationindormitories.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.exception.AccommodationException;
import ru.tpu.accommodationindormitories.exception.RoomNotFoundException;
import ru.tpu.accommodationindormitories.exception.StudentNotFoundException;
import ru.tpu.accommodationindormitories.model.Room;
import ru.tpu.accommodationindormitories.model.Student;
import ru.tpu.accommodationindormitories.repository.RoomRepository;
import ru.tpu.accommodationindormitories.repository.StudentRepository;
import ru.tpu.accommodationindormitories.service.interfaces.AccommodationService;
import ru.tpu.accommodationindormitories.validator.AccommodationValidator;
import ru.tpu.accommodationindormitories.validator.ValidationResult;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;
    private final AccommodationValidator accommodationValidator;
    @Override
    @Transactional
    public void accommodationStudentToRoom(Long studentId, Long roomId) {
        // Блокируем комнату на время транзакции
        Room room = roomRepository.findByIdWithLock(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new StudentNotFoundException(studentId));

        ValidationResult validationResult = accommodationValidator.validateAll(student, room);
        if(!validationResult.isValid()) {
            throw new AccommodationException(validationResult.getErrors());
        }

        student.setRoom(room);
        room.getStudents().add(student);
        room.setNumberOfSeats(room.getNumberOfSeats()+1);
        student.setCheckInDate(LocalDate.now());
        if(room.getNumberOfSeats()>=room.getRoomCapacity()) {
            room.setIsBusy(true);
        }

        //после добавим отправку уведомления студенту о том что он заселен в комнату
    }
}
