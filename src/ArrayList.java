import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayList implements Properties{
    private static final int INIT_SIZE = 16;
    private static final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;


    private void resize(int newLength){
        Object[] newArray = new Object[newLength];
        IntStream.range(0, array.length).forEach(i -> newArray[i] = array[i]);
        array = newArray;
    }

    @Override
    public void addNewElement(Object item) {
        if(pointer == array.length-1){
            resize(array.length*2);
        }
        array[pointer++] = item;
    }

    @Override
    public void searchElement() {

    }

    @Override
    public void getElementByIndex(Object index) {
        for (int i=0; i<array.length; i++){
            if ((int)index == i){
                System.out.println(array[i]);
            }
        }
    }

    @Override
    public void delElementByIndex(Object index) {
        IntStream.range((int) index, pointer).forEach(i -> array[i] = array[i + 1]);
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE){
            resize(array.length/2);
        }
    }

    @Override
    public void Bust() {
        Arrays.stream(array).forEach(System.out::println);
    }
}
