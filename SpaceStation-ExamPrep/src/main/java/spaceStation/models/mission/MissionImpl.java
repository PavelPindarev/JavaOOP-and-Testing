package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {
        for (int index = 0; index < astronauts.size(); index++) {
            Astronaut currentAstronaut = astronauts.get(index);
            //взимаме всички items на планетата
            for (int item = 0; item < planet.getItems().size(); item++) {
                String currentItem = planet.getItems().get(item);
                currentAstronaut.getBag().getItems().add(currentItem);
                planet.getItems().remove(currentItem);
                item--;
                currentAstronaut.breath();
                //проверка дали астронавта може да диша
                if (!currentAstronaut.canBreath()) {
                    astronauts.remove(currentAstronaut);
                    index--;
                    break;
                }
            }
        }
    }
}
