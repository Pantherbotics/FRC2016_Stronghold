package org.usfirst.frc.team3863.util;

import edu.wpi.first.wpilibj.buttons.Trigger;

import java.util.*;

/**
 * Created by Fox on 3/12/2016.
 * Project: 2016Robot
 */
@SuppressWarnings("SameParameterValue")
public class TriggerCollection extends Trigger {

    public final boolean isAnd;

    public final List<Trigger> list;

    public TriggerCollection(boolean isAnd, Trigger... args) {
        this.isAnd = isAnd;
        if(args != null){
            list = Arrays.asList(args);
        } else {
            list = new ArrayList<>();
        }
    }

    @Override
    public boolean get() {
        for (Trigger t : list) {
            if (isAnd != t.get()) return !isAnd;
        }
        return isAnd;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean add(Trigger trigger) {
        return list.add(trigger);
    }

    public void add(int index, Trigger element) {
        list.add(index, element);
    }

    public Trigger remove(int index) {
        return list.remove(index);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public void clear() {
        list.clear();
    }

    public boolean addAll(int index, Collection<? extends Trigger> c) {
        return list.addAll(index, c);
    }

    public boolean addAll(Collection<? extends Trigger> c) {
        return list.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    public Trigger get(int index) {
        return list.get(index);
    }

    public Trigger set(int index, Trigger element) {
        return list.set(index, element);
    }
}
