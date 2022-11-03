package org.binar.chapter4.service;

import org.binar.chapter4.model.film;
import org.binar.chapter4.model.schedule;

import java.util.List;

public interface IScheduleService {
    List<schedule> viewSchedule(film film);

}
