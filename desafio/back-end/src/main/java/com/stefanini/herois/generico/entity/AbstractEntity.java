package com.stefanini.herois.generico.entity;

import com.stefanini.herois.util.GeradorId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class AbstractEntity implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(length = 15)
    private String id;

    @PrePersist
    private void prePersist() {
        id = GeradorId.gerar();
    }

}
