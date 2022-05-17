
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null); // очищаем массив путем замены всех резюме на null
    }

    void save(Resume r) {
        if (r != null && !r.uuid.isEmpty()) { // если резюме существует и uuid резюме не пусто
            for (int i = 0; i <= storage.length - 1; i++) { // то проходим циклом по массиву
                if (storage[i] == null) { //нашли пустую ячейку
                    storage[i] = r; // сохраняем в нее резюме
                    break; // прекращаем цикл, чтоб не проверять все 10000
                }
            }
        }
    }

    Resume get(String uuid) {
        if (uuid != null && !uuid.isEmpty()) { // если uuid корректный
            for (int i = 0; i <= storage.length - 1; i++) { // то проходим циклом по массиву
                if (storage[i] != null && uuid.equalsIgnoreCase(storage[i].uuid)) { // если находим в массиве uuid, соответствующий искомому
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (uuid != null) { // если резюме существует
            for (int i = 0; i <= storage.length - 1; i++) { // то проходим циклом по массиву
                if (storage[i] != null && uuid.equalsIgnoreCase(storage[i].uuid)) { // если находим в массиве uuid, соответствующий искомому
                    storage[i] = null; // удаляем его
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] fillStorage = new Resume[size()]; //создали копию массива, размер которого зависит от кол-ва резюме в базе
        int indexFS = 0; //создали счетчик для подсчета резюме
        for (int i = 0; i <= storage.length - 1; i++) { //циклом прошли по массиву
            if (storage[i] != null) { //если находит резюме,
                fillStorage[indexFS] = storage[i]; // то в элемент нового массива присваивается резюме из storage
                indexFS++; // увеличиваем элемент нового массива и ищем для него новое резюме
            }
        }
        return fillStorage; // возвращаем новый массив, состоящий только из резюме (без null)
    }

    int size() {
        int count = 0;//создали счетчик размера заполненного массива
        for (int i = 0; i <= storage.length - 1; i++) { //циклом прошли по массиву
            if (storage[i] != null) { //если находит резюме,
                count++; // то счетчик увеличиваем на 1
            }
        }
        return count; //возвращаем количество резюме в массиве
    }
}