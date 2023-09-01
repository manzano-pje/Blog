package com.pjem.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTag;
    private String name;

    /****
     * RELATIONS
     */

    @ManyToOne
    @JoinColumn(name = "tag_id", insertable = false, updatable = false)
    Posts posts;
}
