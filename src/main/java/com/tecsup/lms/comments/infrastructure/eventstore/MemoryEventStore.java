package com.tecsup.lms.comments.infrastructure.eventstore;


import java.util.*;

public class MemoryEventStore {

    private final Map<String, List<Object>> store = new HashMap<>();

    public void append(String aggregateId, List<Object> events) {
        store.computeIfAbsent(aggregateId, id -> new ArrayList<>()).addAll(events);
    }

    public List<Object> load(String aggregateId) {
        return store.getOrDefault(aggregateId, Collections.emptyList());
    }
}

