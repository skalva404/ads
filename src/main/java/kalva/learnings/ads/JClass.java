package kalva.learnings.ads;

import java.util.HashMap;

public class JClass {
    public static void main(String[] args) {

        SClass sClass = new SClass(new HashMap<>());
        System.out.println(sClass.getMap());
    }
}
