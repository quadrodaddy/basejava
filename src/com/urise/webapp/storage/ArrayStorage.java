package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public boolean check(String uuid) {
        boolean search = true;
        for (int i = 0; i < size; i++) {
            if (uuid.equalsIgnoreCase(storage[i].getUuid())) {
                return false;
            }
        }
        System.out.println("Error: not resume " + uuid);
        return search;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public void update(Resume r) {
        check(r.getUuid());
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(r)) {
                storage[i].setUuid("New uuid");
            }
        }
    }

    public void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null && size < storage.length - 1) {
                storage[i] = r;
                size++;
                break;
            }
//            if (storage[i].equals(r)) {
//                System.out.println("Error: resume " + storage[i] + " is exists");
//            }
        }
    }


    public Resume get(String uuid) {
        check(uuid);
        for (int i = 0; i < size; i++) {
            if (uuid.equalsIgnoreCase(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        check(uuid);
        for (int i = 0; i < size; i++) {
            if (uuid.equalsIgnoreCase(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
