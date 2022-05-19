
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0; // добавил поле для определения количества резюме

    void clear() {
        Arrays.fill(storage, 0, size, null); // исправил метод fill
    }

    void save(Resume r) {
        if (r != null && !r.uuid.isEmpty()) {
            for (int i = 0; i <= storage.length - 1; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                    size++; //добавил инкремент
                    break;
                }
            }
        }
    }

    Resume get(String uuid) {
        if (uuid != null && !uuid.isEmpty()) {
            for (int i = 0; i <= size - 1; i++) { // исправил на size, чтоб весь массив не проходить
                if (uuid.equalsIgnoreCase(storage[i].uuid)) { //убрал проверку if storage[i] != null
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (uuid != null) {
            for (int i = 0; i <= size - 1; i++) { // исправил на size,
                if (uuid.equalsIgnoreCase(storage[i].uuid)) { //убрал проверку if storage[i] != null
                    storage[i] = null;
                    storage[i] = storage[size - 1]; // переместил пустое рюзюме в следующую ячейку за базой резюме
                    storage[size - 1] = null;
                    size--;
                }
            }
        }
    }// крайний элемент сайз копирую

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() { //убрал цикл из метода
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() { // убрал цикл, привел к примитиву, добавив невозможность уйти в минус
        return size;
    }
}
