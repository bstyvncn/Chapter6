package org.binar.chapter4.service;

import org.binar.chapter4.model.film;
import org.binar.chapter4.model.schedule;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IScheduleService {
    List<schedule> viewSchedule(film film);

}
