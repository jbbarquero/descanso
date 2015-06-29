/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malsolo.javaee7.descanso.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author jbbarquero
 */
public class OccurrenceRepository {
    
    private static final Long KIND_1 = 1L;
    private static final Long KIND_2 = 2L;
    
    private static final Map<Long, Occurrence> repo = new HashMap<>();
    
    static {
        repo.put(1L, new Occurrence(1L, KIND_1, "Valor", new Date()));
        repo.put(2L, new Occurrence(2L, KIND_1, "Miedo", new Date()));
        repo.put(3L, new Occurrence(3L, KIND_2, "Nada", new Date()));
    }
    
    public Occurrence find(Long id) {
        return OccurrenceRepository.repo.get(id);
    }
    
    public List<Occurrence> findAll() {
        return new ArrayList<>(OccurrenceRepository.repo.values());
    }

    public Occurrence persist(Occurrence occurrence) {
        return OccurrenceRepository.repo.put(occurrence.getId(), occurrence);
    }

    public Occurrence remove(Long id) {
        return OccurrenceRepository.repo.remove(id);
    }
}
