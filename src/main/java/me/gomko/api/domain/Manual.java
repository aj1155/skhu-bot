package me.gomko.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.gomko.api.util.ManualType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Manki Kim on 2017-03-10.
 */
@Entity
@Table(name = "MANUAL")
@Getter
@Setter
@ToString
public class Manual extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ManualType manualType;

    @Column(name = "message")
    private String message;

}
