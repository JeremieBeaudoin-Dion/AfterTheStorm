package jGameFramework.core;

import java.util.Stack;

/**
 * An object which takes care of Object's IDs. This is useful
 * when creating multiple identical objects and differentiating
 * them.
 *
 * @author Jérémie Beaudoin-Dion
 */
class ObjectIdCounter {

    private int lastId;
    private Stack<Integer> ids;

    ObjectIdCounter(){
        ids = new Stack<>();
        lastId = 0;

        fillStack();
    }

    private void fillStack() {
        int newLastId = lastId + 100000;

        for (int i=lastId; i<newLastId; i++) {
            ids.push(i);
        }
    }

    int next(){
        if (ids.isEmpty()) {
            fillStack();
        }

        return ids.pop();
    }

    void remove(Integer value){
        ids.push(value);
    }

    int size() {
        return lastId - ids.size();
    }

}