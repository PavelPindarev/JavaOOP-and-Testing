package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
        hero = new Hero("Pavel", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateIfIsNull() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateIfIsDuplicate() {
        heroRepository.create(this.hero);
        heroRepository.create(this.hero);
    }

    @Test
    public void testCreateIfItsCorrect() {
        Assert.assertEquals(0, heroRepository.getCount());
        heroRepository.create(this.hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveIfItsNull() {
        heroRepository.remove(null);
    }

    @Test
    public void testRemoveIfItsCorrect() {
        heroRepository.create(this.hero);
        Assert.assertEquals(1, heroRepository.getCount());
        heroRepository.remove(this.hero.getName());
        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        Hero hero1 = new Hero("George", 11);
        Hero hero2 = new Hero("John", 5);
        Hero hero3 = new Hero("Peter", 32);
        this.heroRepository.create(hero1);
        this.heroRepository.create(hero2);
        this.heroRepository.create(hero3);

        Assert.assertEquals(3, heroRepository.getHeroes().size());

        Assert.assertEquals(hero3.getLevel(), this.heroRepository.getHeroWithHighestLevel().getLevel());
        Assert.assertEquals(hero3.getName(), this.heroRepository.getHeroWithHighestLevel().getName());

    }

    @Test
    public void testGetHero() {
        this.heroRepository.create(this.hero);
        Assert.assertEquals(this.hero, this.heroRepository.getHero("Pavel"));
    }
}
