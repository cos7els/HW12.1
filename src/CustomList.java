public class CustomList<T> {
    private Object[] data;
    private int current;

    public CustomList() {
        initialize();
    }

    public void add(T o) {
        if (this.current == this.data.length) {
            this.increaseSize();
        }
        this.data[current++] = o;
    }

    public void add(int index, T o) {
        if (this.checkIndex(index)) {
            this.shiftForward(index);
            this.data[index] = o;
            this.current++;
        } else {
            wrongMessage(index);
        }
    }

    public void clear() {
        initialize();
    }

    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(T o) {
        int index = -1;
        for (int i = 0; i < this.data.length; i++) {
            if (o.equals(this.data[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        return this.current == 0;
    }

    public Object get(int index) {
        if (this.checkIndex(index)) {
            return this.data[index];
        } else {
            wrongMessage(index);
            return null;
        }
    }

    public void set(int index, T o) {
        if (this.checkIndex(index)) {
            this.data[index] = o;
        } else {
            wrongMessage(index);
        }
    }

    public void remove(int index) {
        if (this.checkIndex(index)) {
            if (index != this.data.length - 1) {
                this.shiftBack(index);
            }
            this.data[--this.current] = null;
        } else {
            wrongMessage(index);
        }
    }

    public void remove(T o) {
        this.remove(this.indexOf(o));
    }

    public int size() {
        return this.current;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (this.current == 0) {
            result.append("]");
            return result.toString();
        } else {
            for (int i = 0; i < this.current; i++) {
                if (i < this.current - 1) {
                    result.append(this.data[i]).append(", ");
                } else if (i == this.current - 1) {
                    result.append(this.data[i]).append("]");
                }
            }
        }
        return result.toString();
    }

    private void initialize() {
        this.data = new Object[5];
        this.current = 0;
    }

    private boolean checkIndex(int index) {
        return index < this.current;
    }

    private void increaseSize() {
        Object[] newArray = new Object[this.data.length * 2];
        System.arraycopy(this.data, 0, newArray, 0, this.data.length);
        this.data = newArray;
    }

    private void shiftForward(int index) {
        if (this.current == this.data.length) {
            this.increaseSize();
        }
        for (int i = this.current; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void shiftBack(int index) {
        for (int i = index; i < this.current; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    private void wrongMessage(int index) {
        System.out.printf("Wrong index %d for size %d%n", index, this.current);
    }

}
