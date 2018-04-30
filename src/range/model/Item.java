package range.model;

/**
 *
 * @author dhiogoboza
 * @param <E> element type
 */
public class Item<E extends Comparable> implements Comparable<Item> {
    private int listId;
    private E element;

    public Item(int listId, E item) {
        this.listId = listId;
        this.element = item;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
    
    @Override
    public String toString() {
        return "[" + listId + ", " + element + "]";
    }

    @Override
    public int compareTo(Item o) {
        return getElement().compareTo(o.getElement());
    }
}
