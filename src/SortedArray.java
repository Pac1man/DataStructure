import java.util.stream.IntStream;

public class SortedArray implements Properties {
    private static final int INIT_SIZE = 16;
    private static final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    private void resize(int newLength){
        Object[] newArray = new Object[newLength];
        IntStream.range(0, array.length).forEach(i -> newArray[i] = array[i]);
        array = newArray;
    }

    private Object[] bubleSort(int n){
        int temp = 0;
        for (int i=n; i<array.length; i++){
            for (int j=n+1; i<array.length - j; j++){
                if((int)array[j-1] > (int)array[j]){
                    temp = (int)array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    @Override
    public void addNewElement(Object value) {
        if(pointer == array.length-1){
            resize(array.length*2);
        }
        for (int i=0; i<array.length; i++){
            if ((int)array[i] <= (int)value){
                int a = (int)array[i];
                array[i] = value;
                bubleSort(i);
                value = a; //По идеи дальше сортируется A и так до полной сортировки массива
            }
        }
        array[pointer++] = value;
    }


    @Override
    public void searchElement() {

    }

    @Override
    public void getElementByIndex(Object index) {

    }

    @Override
    public void delElementByIndex(Object index) {

    }

    @Override
    public void Bust() {

    }
}
