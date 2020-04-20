import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Arrays;

@JsonAutoDetect
public class MyArrayList<E> implements Serializable {
    private Object[] elementData;
    private static final int MIN_CAPACITY = 1;
    //private static final Object[] ELEMENT_DATA = new Object[MIN_CAPACITY];
    private int size;


    public MyArrayList(){
        this.elementData = new Object[MIN_CAPACITY];
    }

    public void add (Object value){
            elementData[size] = value;
            size++;
        if (size >= MIN_CAPACITY){
            elementData = Arrays.copyOf(elementData, size+1);
        }
    }

    public void remove(int index){
        if (index <= size){
            elementData[index] = null;
            createNewArray(elementData);
        }
        else System.out.println("This index not found");
    }

    private void createNewArray(Object[] elementData) {
        Object[] temp = new Object[size];
        int j = 0;
        for (int i = 0; i < size; i++){
            temp[j] = (elementData[i] != null ? elementData[i] : elementData[++i]);
            j++;
        }
        size--;
        this.elementData = temp;
    }

    public E get(int index) {
        if (index > size) {
            return (E)"Have no this index";
        }
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        for (int i = 0; i < size; i++){
            System.out.print(elementData[i] + " ");
        }
        return "";
    }


    public Object[] getElementData() {
        return elementData;
    }

    public int getSize() {
        return size;
    }
}
