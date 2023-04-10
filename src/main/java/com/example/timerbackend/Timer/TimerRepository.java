package com.example.timerbackend.Timer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimerRepository extends JpaRepository <TimerEntity, Integer> {

}
