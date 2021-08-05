package org.springframework.testIgnore;

/**
 * @author wangchao
 * @description TODO
 * @date 2021/07/14 8:53
 */
public class IgnoreOther{

    private PoJoA poJoA;
    private PoJoB poJoB;

    public void setPoJoA(PoJoA poJoA) {
        this.poJoA = poJoA;
    }

    public void setPoJoB(PoJoB poJoB) {
        this.poJoB = poJoB;
    }

    public IgnoreOther(PoJoA poJoA, PoJoB poJoB) {
        this.poJoA = poJoA;
        this.poJoB = poJoB;
    }

    public IgnoreOther() {
    }

    @Override
    public String toString() {
        return "IgnoreOther{" +
                "poJoA=" + poJoA +
                ", poJoB=" + poJoB +
                '}';
    }
}
