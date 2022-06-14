package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage{
    private static final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;
    private static final int RESUME_IS_EMPTY = -1;

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return RESUME_IS_EMPTY;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Error: not resume " + r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println("Error: storage is full");
        } else if (findIndex(r.getUuid()) >= 0) {
            System.out.println("Error: resume " + r.getUuid() + " is exists");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Error: not resume " + uuid);
        } else {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Error: not resume " + uuid);
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
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


