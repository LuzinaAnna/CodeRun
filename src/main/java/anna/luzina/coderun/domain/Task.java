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
    private Integer id;

    @Setter
    @Getter
    private String title;

    @OneToMany
    @Setter
    @Getter
    private Set<Tag> tags;

    @Setter
    @Getter
    private int numberSolvedCorrectly;

    @Getter
    @Setter
    private int numberSent;

    @Getter
    @Setter
    private String description;


    public double getDifficult() {
        if (numberSent == 0){
            return 0;
        }
        return (double)numberSolvedCorrectly / numberSent;
    }

    public String getShortTaskDescription(){
        return description.substring(0, 255) + "...";
    }


}
