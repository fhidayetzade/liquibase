package springdata.producttask1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "teacher",fetch = FetchType.LAZY)
    Set<Student> students = new HashSet<>();
}
