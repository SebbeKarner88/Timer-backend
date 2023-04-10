package com.example.timerbackend.TimerEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Timer")
@Table(name = "timer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimerEntity {

    @Id
    @SequenceGenerator(
            name = "time_seq",
            sequenceName = "time_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "time_seq"
    )

    @Column(name = "time_id")
    private Integer id;

    @Column(name = "time_val")
    private Integer time;
}
