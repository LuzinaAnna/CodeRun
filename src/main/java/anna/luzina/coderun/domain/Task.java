package anna.luzina.coderun.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private Long id;

    @Setter
    @Getter
    private String title;

    @OneToMany
    @Setter
    @Getter
    private Set<Tag> tag;


    @Lob
    @Getter
    @Setter
    private String description;

    @Getter
    private double difficult;
}
