package com.example.timerbackend.Timer;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/timer")
public class TimerController {

    private final TimerService timerService;

    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @CrossOrigin
    @PostMapping
    public TimerDTO PostTime(@RequestBody TimerDTO timerDTO) {
        return timerService.postTime(timerDTO)
                .map(TimerController::timeDTO)
                .orElse(null);
    }

    @CrossOrigin
    @GetMapping
    public List<TimerDTO> GetTime() {
        return timerService.getTime()
                .stream()
                .map(TimerController::timeDTO)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @PostMapping("/del")
    public Boolean DeleteTime(@RequestBody TimerDTO timerDTO) {
        return timerService.DeleteTime(timerDTO.id());
    }


    private static TimerDTO timeDTO(TimerEntity timerEntity) {
        return new TimerDTO(
                timerEntity.getId(),
                timerEntity.getTime()
        );
    }
}
