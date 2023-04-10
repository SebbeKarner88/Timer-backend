package com.example.timerbackend.Timer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TimerService {

    private final TimerRepository timerRepository;

    public TimerService(TimerRepository timerRepository) {
        this.timerRepository = timerRepository;
    }

    public Optional<TimerEntity> postTime(TimerDTO timerDTO) {
        TimerEntity timerEntity = new TimerEntity(
                null,
                timerDTO.time()
        );
        timerRepository.save(timerEntity);
        return Optional.of(timerEntity);
    }

    public List <TimerEntity> getTime() {
        return timerRepository.findAll();
    }

    public Boolean DeleteTime(Integer id) {
        if (timerRepository.existsById(id)) {
        timerRepository.deleteById(id);
        return true;
        }
        return false;
    }
}
