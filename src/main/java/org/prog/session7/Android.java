package org.prog.session7;

public class Android implements IPhone {
    public String color;
    public String modelName;

    public void call(String contact) {
        System.out.println("calling " + contact);
    }

    public void unlock() {
        System.out.println("unlock by fingerprint");
    }

    @Override
   public int hashCode() {
        String valueToHash = color + modelName;
        return valueToHash.hashCode();
    }

    @Override
   public boolean equals(Object obj) {
        if (obj instanceof Android) {
            Android android = (Android) obj;
            int hashCode1 = (color + modelName).hashCode();
            int hashCode2 = (android.color + android.modelName).hashCode();
            return hashCode1 == hashCode2;
        }
        return false;
    }
}


