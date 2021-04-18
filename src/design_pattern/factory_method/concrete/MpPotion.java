package design_pattern.factory_method.concrete;

import design_pattern.factory_method.framework.Item;

public class MpPotion implements Item {
    @Override
    public void use() {
        System.out.println("마력 회복");
    }
}
