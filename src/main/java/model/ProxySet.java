package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ProxySet implements Set{

    private PersonaDao personaDao;
    private int ID;

    public ProxySet(PersonaDao personaDao, int id) {
        this.personaDao = personaDao;
        ID = id;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) { //modificar este
        Set<Telefono> telefonos = personaDao.numeroPorId(this.ID);

        return telefonos.toArray(new Telefono[telefonos.size()]);

    }
}
