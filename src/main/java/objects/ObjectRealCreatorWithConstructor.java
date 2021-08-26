package objects;

public class ObjectRealCreatorWithConstructor extends ObjectCreatorWithConstructor<Child1> {

    protected Child1 getNew(){
        return new Child1();
    }

}
