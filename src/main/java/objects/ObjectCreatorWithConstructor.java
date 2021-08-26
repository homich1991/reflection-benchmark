package objects;

public abstract class ObjectCreatorWithConstructor<E extends BaseObject> {

    protected abstract E getNew();

    public E getObject(){
        return getNew();
    }
}
