package so.ego.space.domains.meeting.domain.domain;

import lombok.*;
import so.ego.space.domains.project.domain.domain.Project;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "meeting")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Meeting {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String name;
    private String goal;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MeetingCheckType check;

    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public void updateMeetingGoal(String goal) {
        this.goal = goal;
    }

    public void updateMeetingStatus(MeetingCheckType check) {
        this.check = check;
    }

}
