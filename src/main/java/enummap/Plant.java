package enummap;

import java.util.Objects;

public class Plant {

    enum LifeCycle {
        ANNUAL,     // per year
        PERENNIAL,  // per many years
        BIENNIAL    // per 2 years
    }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Objects.equals(name, plant.name) &&
                lifeCycle == plant.lifeCycle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lifeCycle);
    }
}
