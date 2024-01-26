package com.ichwan.async.api;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Ichwan
 * Reactive can't use jakarta.persistence in @Entity and @Id
 */
@Data
@Builder
@AllArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
}
