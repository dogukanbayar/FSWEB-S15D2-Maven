package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public void setAnnsTasks(Set<Task> annsTasks) {
        this.annsTasks = annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public void setBobsTasks(Set<Task> bobsTasks) {
        this.bobsTasks = bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public void setCarolsTasks(Set<Task> carolsTasks) {
        this.carolsTasks = carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public void setUnassignedTasks(Set<Task> unassignedTasks) {
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String owner) {
        if (owner == null) {
            return new HashSet<>();
        }
        switch (owner.toLowerCase(Locale.ENGLISH)) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(this.annsTasks, this.bobsTasks, this.carolsTasks);
            case "unassigned":
                return this.unassignedTasks;
            default:
                return new HashSet<>();
        }
    }

    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        if (sets != null) {
            for (Set<Task> set : sets) {
                if (set != null) {
                    union.addAll(set);
                }
            }
        }
        return union;
    }

    public Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();
        if (sets != null) {
            for (Set<Task> set : sets) {
                if (set != null) {
                    union.addAll(set);
                }
            }
        }
        return union;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersection = new HashSet<>();
        if (first != null && second != null) {
            intersection.addAll(first);
            intersection.retainAll(second);
        }
        return intersection;
    }

    public Set<Task> getIntersect(Set<Task> first, Set<Task> second) {
        return getIntersection(first, second);
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> difference = new HashSet<>();
        if (first != null) {
            difference.addAll(first);
            if (second != null) {
                difference.removeAll(second);
            }
        }
        return difference;
    }

    public Set<Task> getDifference(Set<Task> first, Set<Task> second) {
        return getDifferences(first, second);
    }
}
