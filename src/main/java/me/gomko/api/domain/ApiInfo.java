package me.gomko.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Manki Kim on 2017-01-09.
 */
@Entity
@Table(name = "API_INFO")
@Getter
@Setter
@ToString
public class ApiInfo extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "path")
    private String path;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}
