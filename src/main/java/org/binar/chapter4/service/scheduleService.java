package org.binar.chapter4.service;

import org.binar.chapter4.model.film;
import org.binar.chapter4.model.schedule;
import org.binar.chapter4.repositories.scheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class scheduleService implements IScheduleService{
    @Autowired
    scheduleRepository scheduleRepository;

    @Override
    public List<schedule> viewSchedule(film film) {
        List<schedule> s = scheduleRepository.viewScheduleByFilm(film.getFilmID());

        return s;
    }
}
//
//5. Menampilkan jadwal dari film tertentu