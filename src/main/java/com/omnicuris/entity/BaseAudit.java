package com.omnicuris.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdDate", "updatedDate"},
        allowGetters = true
)
@Setter
@Getter
public class BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_created", nullable = false, updatable = false)
    @CreatedDate
    @JsonFormat(pattern = "dd MMM yyyy hh:mm:ss")
    private LocalDateTime dateCreated;

    @Column(name = "last_updated")
    @LastModifiedDate
    @JsonFormat(pattern = "dd MMM yyyy hh:mm:ss")
    private LocalDateTime lastUpdated;

    @Column(name = "active")
    private boolean active = true;
}
