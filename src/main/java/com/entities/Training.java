package com.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Training implements Serializable {

    @Id @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "training")
    private Collection<Student> students;

}
