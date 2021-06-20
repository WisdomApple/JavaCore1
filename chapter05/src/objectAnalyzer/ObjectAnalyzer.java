package objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private final ArrayList<Object> visited = new ArrayList<>();

    /**
     * Converts an object to a string representation that lists all fields.
     *
     * @param obj an object
     *            return a string with the object's class name and all field names and
     *            values
     */

    public String toString(Object obj) {
        if (obj == null)
            return null;
        visited.add(obj);
        Class cl = obj.getClass();
        if (cl == String.class)
            return (String) obj;
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[] {\n";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0)
                    r += ", \n ";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive())
                    r += val;
                else r += toString(val);
            }
            return r + "\n}";
        }

        String r = cl.getName();
        // inspect the fields of this class and all superclasses
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!r.endsWith("["))
                        r += ", ";
                    r += field.getName();
                    try {
                        Class t = field.getType();
                        Object val = field.get(obj);
                        if (t.isPrimitive())
                            r += val;
                        else
                            r += toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }
}
