package ru.tpu.accommodationindormitories.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tpu.accommodationindormitories.model.Room;
import ru.tpu.accommodationindormitories.model.Student;
import ru.tpu.accommodationindormitories.repository.RoomRepository;
import ru.tpu.accommodationindormitories.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AccommodationValidator {
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    public ValidationResult validateAll(Student student, Room room) {
        List<String> errors = new ArrayList<>();

        if(!checkExists(student, room)) {
            errors.add("Таких записей нет в базе данных!");
        }

        if(!checkGender(student, room)) {
            errors.add("Несоответствие пола студента и комнаты!");
        }

        if(!checkCourse(student, room)) {
            errors.add("Курсы студентов сильно различаются!");
        }

        if(!checkFaculty(student, room)) {
            errors.add("Студенты учатся на разных факультетах!");
        }

        if(!checkNumberOfSeats(room)) {
            errors.add("В комнате не хватает мест!");
        }

        if(!checkRoomAvailability(student)) {
            errors.add("Студент уже заселен в комнату!");
        }

        if(!checkRoomIsBusy(room)) {
            errors.add("Комната переполнена!");
        }

        if(!checkRoomIsDisabledPeople(student, room)) {
            errors.add("Эта комната для студентов с ограниченными возможностями!");
        }

        if(!checkViolations(student, room)) {
            errors.add("Студент слишком непримерный для заселения в комнату!");
        }

        return new ValidationResult(errors.isEmpty(), errors);

    }

    //Мето для проверки существования таких записей в бд
    private boolean checkExists(Student student, Room room) {
        return student!=null && room!=null;
    }

    //Метод для проверки соответствия пола студента полу комнаты
    public boolean checkGender(Student student, Room room) {
        return student.getGender()==room.getGender();
    }

    //Курс с курсами
    public boolean checkCourse(Student student, Room room) {
        for(Student studentElement: room.getStudents()) {
            if(Math.abs(studentElement.getCourse()-student.getCourse())>2) {
                return false;
            }
        }
        return true;
    }

    //Проверка на сходство факультетов
    public boolean checkFaculty(Student student, Room room) {
        for(Student studentElement: room.getStudents()) {
            if(!student.getFaculty().equals(studentElement.getFaculty())) {
                return false;
            }
        }
        return true;
    }

    //Метод для проверка количества мест
    public boolean checkNumberOfSeats(Room room) {
        return (room.getNumberOfSeats()+1)<=room.getRoomCapacity();
    }

    //Метод проверки на наличие у студента уже комнаты
    public boolean checkRoomAvailability(Student student) {
        return student.getRoom()!=null;
    }

    //Проверяется на ремонте ли комната
    public boolean checkRoomIsBusy(Room room) {
        return !room.getIsBusy();
    }

    //Комната для людей с ограниченными возможностями
    public boolean checkRoomIsDisabledPeople(Student student, Room room) {
        return student.getDisabledStudent()==room.getForDisabledPeople();
    }

    //Метод для проверки на количество нарушений
    public boolean checkViolations(Student student, Room room) {
        if (student.getNumberOfViolations() == 0) {
            return true;
        }
        return room.getStudents().stream()
                .allMatch(s -> s.getNumberOfViolations() > 0);
    }


}
