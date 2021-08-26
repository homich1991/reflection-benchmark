package objects;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class ObjectCreatorWithReflection<E extends BaseObject> {


    Class<E> entityClass;
    Constructor<E> declaredConstructor;

    public ObjectCreatorWithReflection() {
        entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            declaredConstructor = entityClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    protected E getNewWithCachedConstructor() {
        try {
            return declaredConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected E getNew() {
        try {
            return entityClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public E getObject() {
        return getNew();
    }

    public E getObjectWithCachedConstructor() {
        return getNewWithCachedConstructor();
    }
}
