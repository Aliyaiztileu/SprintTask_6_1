package kz.group119.SprintTask_6_1.SprintTask_6_1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name= "t_requests")
@NoArgsConstructor
@AllArgsConstructor

public class ApplicationRequest {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    private String userName;
    private String courseName;
    private String commentary;
    private String phone;
    private boolean handled;
}
