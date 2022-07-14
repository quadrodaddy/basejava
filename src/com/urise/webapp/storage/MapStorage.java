package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storageMap = new HashMap<>();

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        storageMap.replace((String) uuid, r);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        storageMap.put((String) uuid, r);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return storageMap.get((String) uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        storageMap.remove((String) uuid);
    }

    @Override
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storageMap.size();
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object uuid) {
        return storageMap.containsKey((String) uuid) ;
    }

}

