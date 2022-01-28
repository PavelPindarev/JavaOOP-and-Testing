package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double OXYGEN_VALUE = 70;

    public Biologist(String name) {
        super(name, OXYGEN_VALUE);
    }

    @Override
    public void breath() {
        setOxygen(OXYGEN_VALUE - 5);
    }
}

